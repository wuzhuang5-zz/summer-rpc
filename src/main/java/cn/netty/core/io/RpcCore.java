package cn.netty.core.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Future;

/**
 * @author wz
 */
public class RpcCore implements RpcProtocol {

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private ServerSocket serverSocket;
    private Socket socket;
    @Override
    public void export(int port) {
        start(port);
    }
    public void start(int port){

    }
    @Override
    public Object refer(Class interfaceClass, String host, int port) {
        return null;
    }
}
