package cn.wz.register;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.rpc.URL;

/**
 * @Author: wz
 */
public class RegisterFactory {
    public static final String ZK = "zookeeper";

    public static Register createRegister(URL serviceUrl, URL registerUrl) {
        if (ZK.equals(registerUrl.getProtocol())) {
            return new ZookeeperRegister(registerUrl.getHost()+":"+registerUrl.getPort());
        }
        //todo 默认使用本地
        throw new SummerFrameworkException("请选择注册中心");
    }
}
