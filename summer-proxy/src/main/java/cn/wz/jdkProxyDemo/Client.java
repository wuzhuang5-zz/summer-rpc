package cn.wz.jdkProxyDemo;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        ProxyCompanyHandler companyHandler = new ProxyCompanyHandler(new Me());
       Rent rent =  (Rent) Proxy.newProxyInstance(Rent.class.getClassLoader(),  Rent.class.getInterfaces(), companyHandler);
    }
}
