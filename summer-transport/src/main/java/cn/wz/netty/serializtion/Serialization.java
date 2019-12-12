package cn.wz.netty.serializtion;

import java.io.IOException;

/**
 * @Author: wz
 */
public interface Serialization {
    /**
     * 序列化
     * @param object
     * @return
     */
    byte[] serialize(Object object) throws IOException;

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T  deserialize(byte[] bytes, Class<T> clazz);
}
