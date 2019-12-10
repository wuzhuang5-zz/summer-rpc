package cn.wz.netty;

import cn.wz.common.ChannelState;
import cn.wz.common.log.LoggerUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;

import java.net.URL;

/**
 * @author wz
 */
public class NettyServer implements Server {

    private ChannelState state = ChannelState.UNINIT;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private URL url;
    @Override
    public boolean open() {
        if (isAvailable()) {
            LoggerUtil.warn("NettyServer already open: url=" + "");
        }
        if (bossGroup == null) {
            bossGroup = new NioEventLoopGroup(1);
            workerGroup = new NioEventLoopGroup();
        }
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(ServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline channelPipeline = ch.pipeline();
                        channelPipeline.addLast()
                    }
                });
        return true;
    }

    private boolean isAvailable() {
        return state.isAliveState();
    }
}
