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
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                //阻塞在accept()方法上
                socket = server.accept();
            }
        } finally {
            if (server != null) {
                server.close();
                server = null;
            }
        }
    }
}
