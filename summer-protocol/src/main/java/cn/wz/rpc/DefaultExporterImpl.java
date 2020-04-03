package cn.wz.rpc;

import cn.wz.netty.NettyServer;
import cn.wz.netty.Server;

/**
 * @Description: 导出实现者
 * @Author: wz
 */
public class DefaultExporterImpl implements Exporter{

    private Server server;

    public DefaultExporterImpl(URL url) {
        this.server = new NettyServer(url);
    }
    @Override
    public <T> boolean export(Class<T> interfaceClass, URL url, T ref) {
        //todo
        return server.open();
    }
}
