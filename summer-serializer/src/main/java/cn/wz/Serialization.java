package cn.wz;

import java.io.IOException;

/**
 * 序列化接口
 */
public interface Serialization {
    /**
     * 序列化
     * @param object
     * @return
     * @throws IOException
     */
    byte[] serialize(Object object) throws IOException;

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException;
}
