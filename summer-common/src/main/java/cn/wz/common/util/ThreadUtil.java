package cn.wz.common.util;

import java.util.concurrent.*;

/**
 * @Description: 线程工具类
 * @Author: wz
 * @Date: 2020-04-14
 */
public class ThreadUtil {
    public void testThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
    }
}
