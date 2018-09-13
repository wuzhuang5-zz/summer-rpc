package cn.summer;

import cn.summer.protocol.RpcCore;


/**
 * 服务消费方
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        RpcCore rpcCore = new RpcCore();
        HelloService service = (HelloService) rpcCore.refer(HelloService.class,"127.0.0.1",1234);
        for (int i = 0; i < 10; i++) {

                String hello = service.sayHello("World " + Thread.currentThread().getName());
                System.out.println(hello);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
}
