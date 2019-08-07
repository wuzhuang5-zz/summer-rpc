package cn.wz.config.handler;

import cn.wz.rpc.Exporter;
import cn.wz.rpc.URL;

import java.util.List;

public class ConfigHandlerImpl implements ConfigHandler {
    @Override
    public <T> Exporter export(Class<T> interfaceClass, T ref, List<URL> registerList) {
        URL url = registerList.get(0);
        Protocol
        return null;
    }
}
