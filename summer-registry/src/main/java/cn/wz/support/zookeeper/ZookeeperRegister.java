package cn.wz.support.zookeeper;

import cn.wz.NotifyListener;
import cn.wz.rpc.URL;
import cn.wz.support.AbstractRegistry;

import java.util.List;

public class ZookeeperRegister extends AbstractRegistry {
    @Override
    protected void doRegister(URL url) {

    }

    @Override
    public void subscribe(URL url, NotifyListener listener) {

    }

    @Override
    public void unSubscribe(URL url, NotifyListener listener) {

    }

    @Override
    public List<URL> discover(URL url) {
        return null;
    }

    @Override
    public void unRegister(URL url) {

    }

    @Override
    public void alailable(URL url) {

    }

    @Override
    public void unAlailable(URL url) {

    }
}
