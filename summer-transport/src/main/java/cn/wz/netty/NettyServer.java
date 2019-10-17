package cn.wz.netty;

import cn.wz.common.ChannelState;

public class NettyServer implements Channel {

    private ChannelState state = ChannelState.UNINIT;

    @Override
    public boolean open() {
        return this.isAvailable();
    }

    public boolean isAvailable() {
        return true;
    }
}
