package cn.summer.protocol;

/**
 * @author wz
 * rpc协议
 */
public interface RpcProtocol {

    void export(Object service, int port) throws Exception;

    Object refer(Class interfaceClass, String host, int port) throws Exception ;
}
