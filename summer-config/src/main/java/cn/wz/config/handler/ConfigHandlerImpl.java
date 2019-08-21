package cn.wz.config.handler;

import cn.wz.rpc.*;
import cn.wz.rpc.impl.DefaultProvider;
import cn.wz.rpc.impl.DefaultRpcProtocol;

import java.util.List;

public class ConfigHandlerImpl implements ConfigHandler {
    @Override
    public <T> Exporter export(Class<T> interfaceClass, T ref, List<URL> registerList) {
        URL url = registerList.get(0);
        Protocol protocol = new DefaultRpcProtocol();
        Provider<T> provider = new DefaultProvider();
        Exporter exporter = protocol.export(provider, url);
        return exporter;
    }
}
