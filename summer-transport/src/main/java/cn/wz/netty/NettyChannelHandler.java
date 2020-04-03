package cn.wz.netty;

import cn.wz.rpc.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @Author: wz
 */
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg---->"+msg);
        if (msg instanceof NettyMessage) {
            //todo  采用线程池优化
            new Thread(() -> {
                processMessage(ctx, (NettyMessage) msg);
            });
        }
    }

    /**
     * 处理请求
     * @param ctx
     * @param msg
     */
    private void processMessage(ChannelHandlerContext ctx, NettyMessage msg) throws IOException {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        String remoteIp = null;
        if (socketAddress != null) {
            //获取客户端ip
            remoteIp = ((InetSocketAddress) socketAddress).getAddress().getHostAddress();
        }
        byte[] bytes = msg.getData();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInput objectInput = new ObjectInputStream(byteArrayInputStream);
    }
}
