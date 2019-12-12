package cn.wz.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: wz
 */
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof NettyMessage) {
            //todo  采用线程池
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

    }
}
