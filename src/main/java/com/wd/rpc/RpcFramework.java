package com.wd.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework {
    /**
     * 暴露服务
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception {

        if(service == null) {
            throw new IllegalArgumentException("service instance == null");
        }
        if(port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }

        System.out.println("Export service " + service.getClass().getName() + " on port " + port);

        ServerSocket serverSocket = new ServerSocket(port);

        for(;;) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       try {
                           ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                           try {
                               String methodName = inputStream.readUTF();
                               Class<?>[] parameterTypes = (Class<?>[])inputStream.readObject();
                               Object[] arguments = (Object[])inputStream.readObject();
                               ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                               try {
                                   Method method = service.getClass().getMethod(methodName, parameterTypes);
                                   Object result = method.invoke(service,arguments);
                                   outputStream.writeObject(result);
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

    /**
     * 引用服务
     * @param interfaceClass  接口类型
     * @param host 主机
     * @param port 端口
     * @param <T>
     * @return 远程服务
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static<T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception{

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

        System.out.println("get remote service " + interfaceClass.getName() + " from server " +host + ":" + port);

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (InvocationHandler) (proxy, method, args) -> {
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
