package cn.netty.core;

public class Main {
    public static void main(String[] args) {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        helloWorldService.say();
    }
}
