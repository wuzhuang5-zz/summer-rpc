package cn.wz.netty.demo.bio;

import java.net.Socket;

/**
 * @Author: wz
 */
public class TimeServerHandler implements Runnable{
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
