package cn.wz.register;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.rpc.URL;
import org.apache.curator.framework.CuratorFramework;

/**
 * @Author: wz
 */
public class ZookeeperRegister implements Register {

    CuratorFramework zkClient;

    public ZookeeperRegister() {

    }

    @Override
    public void register(URL url) {
        if (url == null) {
            throw new SummerFrameworkException("register url is null");
        }

    }

    private void createNode() {
        //summer://ip:port/cn.wz.summer.demo.DemoService?interface=com.alibaba.dubbo.demo.DemoService&methods=sayHello

//        zkClient = CuratorFrameworkFactory.newClient();
    }
}
