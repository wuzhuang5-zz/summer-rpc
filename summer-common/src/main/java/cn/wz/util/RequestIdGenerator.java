package cn.wz.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * requestId生成器
 */
public class RequestIdGenerator {

    private static final AtomicLong offset = new AtomicLong(0);

    public static long getRequestId() {
        long currentTime = System.currentTimeMillis();
        long count = currentTime + offset.getAndIncrement();
        return (currentTime << 20) + count;
    }

}
