package cn.wz.rpc;

import cn.wz.common.log.LoggerUtil;

/**
 * @Author: wz
 * @Date: 2019/9/16 10:32 下午
 */
public abstract class AbstractNode implements Node{

    private volatile boolean init = false;

    @Override
    public void init() {
        if (init) {
            LoggerUtil.warn(this.getClass().getSimpleName() + " node is already init: " + desc());
            return;
        }
        boolean result = doInit();
    }

    protected abstract boolean doInit();
}
