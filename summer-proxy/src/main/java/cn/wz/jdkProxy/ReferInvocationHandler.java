package cn.wz.jdkProxy;

import cn.wz.Cluster;
import cn.wz.util.RequestIdGenerator;

import java.lang.reflect.Method;
import java.util.List;

public class ReferInvocationHandler<T> extends AbstractRefererHandler {

    public ReferInvocationHandler(Class<T> clz, List<Cluster<T>> clusters) {
        interfaceName = clz.getName();
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DefaultRequest request = new DefaultRequest();
        request.setRequestId(RequestIdGenerator.getRequestId());
        request.setArguments(args);
        request.setMethodName(method.getName());
        request.setInterfaceName(interfaceName);
        return null;
    }
}
