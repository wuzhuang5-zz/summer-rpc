package cn.wz.common;

/**
 * @Author: wz
 * @Date: 2019/9/17 12:56 下午
 */
public enum ChannelState {
    /**
     * 未初始化状态
     */
    UNINIT(0),
    /**
     * 初始化完成
     */
    INIT(1),
    /**
     * 存活可用状态
     */
    ALIVE(2),
    /**
     * 不存活可用状态
     */
    UNALIVE(3),
    /**
     * 关闭状态
     */
    CLOSE(4);

    private int value;

    private ChannelState(int value) {
        this.value = value;
    }

    public boolean isAliveState() {
        return this == ALIVE;
    }
}
