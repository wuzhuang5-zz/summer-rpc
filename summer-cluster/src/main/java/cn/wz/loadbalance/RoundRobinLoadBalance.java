package cn.wz.loadbalance;

import cn.wz.rpc.Referer;
import cn.wz.rpc.Request;

/**
 * 轮询
 */
public class RoundRobinLoadBalance<T> extends AbstractLoadBalance<T> {
    @Override
    public Referer<T> select(Request request) {
        return null;
    }
}
