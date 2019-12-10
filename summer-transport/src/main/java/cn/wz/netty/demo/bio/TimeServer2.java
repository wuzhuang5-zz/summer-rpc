package cn.wz.netty.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: wz
 */
public class TimeServer2 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 1000);
            while (true) {
                socket = serverSocket.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
