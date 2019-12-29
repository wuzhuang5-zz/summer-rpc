package cn.wz.loadbalance;

import cn.wz.rpc.Referer;
import cn.wz.rpc.Request;

/**
 * 负载均衡
 */
public interface LoadBalance<T> {
    /**
     * 根据请求获取路由
     * @return
     */
    Referer<T> select(Request request);
}
