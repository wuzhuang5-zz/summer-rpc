package cn.wz;

import cn.wz.rpc.URL;

import java.util.List;

public interface DiscoveryService {
    /**
     * 订阅服务
     * @param url
     * @param listener
     */
    void subscribe(URL url, NotifyListener listener);

    /**
     * 取消订阅
     * @param url
     * @param listener
     */
    void unSubscribe(URL url, NotifyListener listener);

    /**
     * 发现服务
     * @param url
     * @return
     */
    List<URL> discover(URL url);
}
