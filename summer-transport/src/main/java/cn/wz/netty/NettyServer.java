package cn.wz.netty;

import cn.wz.common.ChannelState;
import cn.wz.common.log.LoggerUtil;

public class NettyServer implements Channel {

    private ChannelState state = ChannelState.UNINIT;

    @Override
    public boolean open() {
        if (isAvailable()) {
            LoggerUtil.warn("NettyServer already open: url=" + "");
        }
        return true;
    }

    public boolean isAvailable() {
        return state.isAliveState();
    }
}
