package cn.wz;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.rpc.URL;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

/**
 * @Author: wz
 * @Date: 2019/11/18 12:28 下午
 */
public class ZookeeperRegister implements Register{

    CuratorFramework zkClient;

    @Override
    public void register(URL url) {
        if (url == null) {
            throw new SummerFrameworkException("register url is null");
        }

    }

    private void createNode() {
        zkClient = CuratorFrameworkFactory.newClient();
    }
}
