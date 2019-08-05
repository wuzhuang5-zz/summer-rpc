package cn.wz.config.handler;

import cn.wz.rpc.Exporter;
import cn.wz.rpc.URL;

import java.util.List;

public interface ConfigHandler {
    <T> Exporter export(Class<T> interfaceClass, T ref, List<URL> registerList);
}
