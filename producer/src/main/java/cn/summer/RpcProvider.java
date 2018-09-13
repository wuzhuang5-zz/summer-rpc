package cn.summer;

import cn.summer.protocol.RpcCore;

/**
 * 服务提供方
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception{

        HelloService service = new HelloServiceImpl();
        RpcCore rpcCore = new RpcCore();
        rpcCore.export(service,1234);

    }
}
