package cn.summer.server;

import cn.summer.service.SummerDemoService;

public class SummerDemoServiceImpl implements SummerDemoService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello "+name);
    }
}
