package cn.wz.jdkProxy;

import cn.wz.rpc.DefaultRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ReferInvocationHandler<T> implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DefaultRequest request = new DefaultRequest();
        request.setRequestId();
        return null;
    }
}
