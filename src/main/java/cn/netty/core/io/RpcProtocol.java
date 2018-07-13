package cn.netty.core.io;

/**
 * rpc协议接口
 */
public interface RpcProtocol {
    /**
     * 暴露端口
     * @param port
     */
    void export(int port);

    /**
     *  引用服务
     * @param interfaceClass
     * @param host
     * @param port
     * @return
     */
    Object refer(Class interfaceClass,String host,int port);
}
