package cn.wz.support;

import cn.wz.Registry;
import cn.wz.rpc.URL;

import java.util.Set;

public abstract class AbstractRegistry implements Registry {
//    private Set<URL> registeredServiceUrls = new Concurrent
    @Override
    public void register(URL url) {
        if(url == null) {

        }
        doRegister(url);
    }

    protected abstract void doRegister(URL url);
}
