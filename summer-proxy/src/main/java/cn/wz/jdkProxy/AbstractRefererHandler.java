package cn.wz.jdkProxy;

import cn.wz.Cluster;

import java.lang.reflect.InvocationHandler;
import java.util.List;

public abstract class AbstractRefererHandler<T> implements InvocationHandler {
    protected List<Cluster<T>> clusters;
    protected Class<T> clz;
    protected String interfaceName;

}
