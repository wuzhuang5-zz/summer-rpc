package cn.summer.registry.impl;

import cn.summer.protocol.URL;
import cn.summer.registry.Registry;

import java.util.List;

/**
 * 模板方法 抽象类构造骨架，部分子类进行扩展
 */
public class AbstractRegistry implements Registry {
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
    public void register(URL url) {

    }

    @Override
    public void remove(URL url) {

    }
}
