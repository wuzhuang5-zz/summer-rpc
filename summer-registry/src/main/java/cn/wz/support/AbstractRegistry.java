package cn.wz.support;

import cn.wz.Registry;
import cn.wz.rpc.URL;

public abstract class AbstractRegistry implements Registry {
    @Override
    public void register(URL url) {
        doRegister(url);
    }

    protected void doRegister(URL url) {

    }
}
