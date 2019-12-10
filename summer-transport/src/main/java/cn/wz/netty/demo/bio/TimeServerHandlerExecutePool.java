package cn.wz.netty.demo.bio;

import java.util.concurrent.*;

/**
 * @Author: wz
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executorService;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task) {
        executorService.execute(task);
    }
}
