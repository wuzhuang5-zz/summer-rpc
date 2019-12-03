package cn.wz.register;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.common.log.LoggerUtil;
import cn.wz.rpc.URL;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;

/**
 * @Author: wz
 */
public class ZookeeperRegister implements Register {

    private CuratorFramework zkClient;
    public ZookeeperRegister(String address) {
        init(address);
    }

    /**
     * 初始化zk客户端
     * @param address ip:port
     */
    private void init(String address) {
        RetryPolicy retryPolicy = new RetryOneTime(1);
        zkClient = CuratorFrameworkFactory.newClient(address, retryPolicy);
        zkClient.start();
    }

    @Override
    public void register(URL url) {
        if (url == null) {
            throw new SummerFrameworkException("register url is null");
        }
        try {
            zkClient.create().forPath("/summer",url.toString().getBytes());
            byte[] result = zkClient.getData().forPath("/summer");
            String str = new String(result);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.error(url.getProtocol()+"创建节点失败");
        }
    }

    private void createNode() {
        //summer://ip:port/cn.wz.summer.demo.DemoService?interface=com.alibaba.dubbo.demo.DemoService&methods=sayHello

//        zkClient = CuratorFrameworkFactory.newClient();
    }
}
