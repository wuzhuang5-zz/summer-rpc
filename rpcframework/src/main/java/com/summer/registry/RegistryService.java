package com.summer.registry;

import com.summer.protocol.URL;

public interface RegistryService {
    /**
     * 注册
     * @param url
     */
    void register(URL url);

    /**
     * 移除
     * @param url
     */
    void remove(URL url);
}
