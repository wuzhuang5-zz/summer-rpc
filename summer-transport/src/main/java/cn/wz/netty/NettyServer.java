package cn.wz.netty;

public class NettyServer implements Channel {

    @Override
    public boolean open() {
        return this.isAvailable();
    }

    public boolean isAvailable() {
        return true;
    }
}
