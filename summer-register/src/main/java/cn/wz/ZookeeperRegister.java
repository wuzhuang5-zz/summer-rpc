package cn.wz;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.rpc.URL;

/**
 * @Author: wz
 * @Date: 2019/11/18 12:28 下午
 */
public class ZookeeperRegister implements Register{

    @Override
    public void register(URL url) {
        if (url == null) {
            throw new SummerFrameworkException("register url is null");
        }

    }
}
