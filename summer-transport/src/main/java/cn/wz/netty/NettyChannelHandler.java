package cn.wz.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @Author: wz
 */
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
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
    private void processMessage(ChannelHandlerContext ctx, NettyMessage msg) {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        String remoteIp = null;
        if (socketAddress != null) {
            remoteIp = ((InetSocketAddress) socketAddress).getAddress().getHostAddress();
        }
        Object result;
        result =
    }
}
