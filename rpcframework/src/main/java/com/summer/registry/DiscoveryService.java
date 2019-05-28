package com.summer.registry;

import com.summer.protocol.URL;

import java.util.List;

public interface DiscoveryService {
    /**
     * 订阅服务
     * @param url
     */
    void subscribe(URL url);

    /**
     * 发现服务
     * @param url
     * @return
     */
    List<URL> discover(URL url);
}
