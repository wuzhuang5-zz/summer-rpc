package cn.wz.rpc.impl;

import cn.wz.netty.Server;
import cn.wz.rpc.Exporter;
import cn.wz.rpc.Provider;

/**
 * 默认rpc暴露实现
 */
public class DefaultRpcExporter implements Exporter {

    protected Server server;

    @Override
    public Provider getProvider() {
        return null;
    }

    @Override
    public void unexport() {

    }

    public boolean doInit() {
        return server.open();
    }

}
