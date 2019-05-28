package cn.summer.protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcCore implements RpcProtocol {

    private static final ZkRegistry zkRegistry = new ZkRegistry();

    @Override
    public void export(Object service, int port) throws Exception{
        /**
         * 参数判断
         */
        if(service == null) {
            throw new IllegalArgumentException("service instance == null");
        }
        if(port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }

        System.out.println("暴露服务 " + service.getClass().getName() + " on port " + port);
        /**
         * 建立serverSocket
         */
        ServerSocket serverSocket = new ServerSocket(port);

        for(;;) {
            try {
                /**
                 * 阻塞监听连接
                 */
                final Socket socket = serverSocket.accept();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            /**
                             * 将socket数据转化为对象
                             */
                            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                            try {
                                /**
                                 * 方法名
                                 */
                                String methodName = inputStream.readUTF();
                                System.out.println("接收到的方法名 : " + methodName);
                                /**
                                 * 方法参数
                                 */
                                Class<?>[] parameterTypes = (Class<?>[])inputStream.readObject();
                                Object[] arguments = (Object[])inputStream.readObject();
                                for (int i=0; i<arguments.length; i++) {
                                    System.out.println("arguments-->"+arguments[i]);
                                }

                                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                                try {

                                    Method method = service.getClass().getMethod(methodName, parameterTypes);
                                    //反射调用本地方法
                                    Object result = method.invoke(service,arguments);
                                    outputStream.writeObject(result);
                                    zkRegistry.registry("127.0.0.1");

                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                                catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object refer(Class interfaceClass, String host, int port) {
        //验证参数
        if(interfaceClass == null) {
            throw new IllegalArgumentException("interfaceClass == null");
        }
        if(! interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The " +interfaceClass.getName() + " must be interfaceClass");
        }
        if(host == null || host.length() == 0) {
            throw new IllegalArgumentException("host == null");
        }
        if(port == 0 || port > 65535) {
            throw new IllegalArgumentException("Invlid port " + port);
        }

        System.out.println("get transport service " + interfaceClass.getName() + " from server " +host + ":" + port);

        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (InvocationHandler) (proxy, method, args) -> {
            Socket socket = new Socket(host,port);
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                try {
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    try{
                        Object result = objectInputStream.readObject();
                        if(result instanceof Throwable) {
                            throw (Throwable) result;
                        }
                        return result;
                    } finally {
                        objectInputStream.close();
                    }
                } finally {
                    outputStream.close();
                }
            } finally {
                socket.close();
            }
        });
    }
    }
