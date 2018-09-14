package cn.summer.registry;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ZkRegistry.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void registry(String url) {
        ZooKeeper zk = connectServer();
        createNode(zk, url);
    }
    /**
     * 连接Zookeeper服务器
     * @return
     */
    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, watchedEvent -> {
                 if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                     latch.countDown();
                 }
            });
            latch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zk;
    }

    /**
     * 创建ZNode
     * @param zooKeeper
     * @param url
     */
    private void createNode(ZooKeeper zooKeeper, String url) {
        try {
            byte[] data = url.getBytes();
            String path = zooKeeper.create(Constant.ZK_PROVIDER_PATH, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.debug("create zookeeper node ({} => {})", path, url);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
