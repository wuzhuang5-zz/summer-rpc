package cn.wz.jdkProxy;

import cn.wz.Cluster;
import cn.wz.rpc.RpcContext;
import cn.wz.switcher.SwitcherService;

import java.lang.reflect.InvocationHandler;
import java.util.List;

public abstract class AbstractRefererHandler<T> implements InvocationHandler {

    protected List<Cluster<T>> clusters;

    protected Class<T> clz;

    protected String interfaceName;

    protected SwitcherService switcherService = null;

    Object invokeRequest(Request request, Class returnType, boolean async) throws Throwable {
        RpcContext curContext = RpcContext.getRpcContext();
        return null;
    }
}
