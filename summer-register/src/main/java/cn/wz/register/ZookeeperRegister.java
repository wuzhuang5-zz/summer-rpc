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
    }

    private void createNode(String path, byte[] data) throws Exception {
        zkClient.create().forPath(path,data);
    }

    private void deleteNode(String path) {

    }
}
