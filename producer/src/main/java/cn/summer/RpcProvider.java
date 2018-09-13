package cn.summer;

/**
 * 服务提供方
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception{

        HelloService service = new HelloServiceImpl();

        RpcFramework.export(service,1234);

    }
}
