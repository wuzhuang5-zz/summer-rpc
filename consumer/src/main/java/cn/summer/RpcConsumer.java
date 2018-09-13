package cn.summer;

/**
 * 服务消费方
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {

        HelloService service = RpcFramework.refer(HelloService.class,"127.0.0.1",1234);

        for (int i=0;i<Integer.MAX_VALUE;i++){

            //服务消费方调用以本地调用方式调用服务
            String hello = service.sayHello("World "+i);

            System.out.println(hello);

            Thread.sleep(1000);
        }

    }
}
