package cn.wz.jdkProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyCompanyHandler implements InvocationHandler {

    private Object subject;

    public ProxyCompanyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介公司找房子");
        method.invoke(subject, args);
        System.out.println("给中介公司付钱");
        return null;
    }
}
