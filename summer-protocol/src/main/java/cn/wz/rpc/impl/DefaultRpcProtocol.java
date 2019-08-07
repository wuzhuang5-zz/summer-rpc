package cn.wz.rpc.impl;

import cn.wz.rpc.AbstractProtocol;
import cn.wz.rpc.Exporter;
import cn.wz.rpc.Provider;
import cn.wz.rpc.URL;

public class DefaultRpcProtocol extends AbstractProtocol {
    @Override
    protected <T> Exporter<T> createExporter(Provider<T> provider, URL url) {
        return new DefaultRpcExporter();
    }
}
