package com.summer.registry.impl;

import com.summer.protocol.URL;
import com.summer.registry.Registry;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 模板方法 抽象类构造骨架，定义protoect方法让子类实现
 */
@Slf4j
public class AbstractRegistry implements Registry {

    private String registryClassName = this.getClass().getSimpleName();

    @Override
    public void register(URL url) {
        if(url == null) {
            log.warn("url不能为空", registryClassName);
        }

    }

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public void subscribe(URL url) {

    }

    @Override
    public List<URL> discover(URL url) {
        return null;
    }



    @Override
    public void remove(URL url) {

    }
}
