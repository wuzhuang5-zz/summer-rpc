package cn.wz.netty.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: wz
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                //阻塞在accept()方法上
                System.out.println("accept()阻塞中。。。");
                socket = server.accept();
                System.out.println("有请求进来。。。");
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                server.close();
                server = null;
            }
        }
    }
}
