package cn.wz.register;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.rpc.URL;

/**
 * @Author: wz
 */
public class RegisterFactory {
    public static final String ZK = "zookeeper";

    public static Register createRegister(URL url) {
        if (ZK.equals(url.getProtocol())) {
            return new ZookeeperRegister(url.getHost()+":"+url.getPort());
        }
        //todo 默认使用本地
        throw new SummerFrameworkException("请选择注册中心");
    }
}
