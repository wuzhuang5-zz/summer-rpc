package cn.wz.netty.codec;

import cn.wz.netty.Channel;

import java.io.IOException;

/**
 * @Author: wz
 */
public interface Codec {

    /**
     * 编码
     * @param channel
     * @param message
     * @return
     */
    byte[] encode(Channel channel, Object message) throws IOException;

    /**
     * 解码
     * @param channel
     * @param bytes
     * @return
     * @throws IOException
     */
    Object decode(Channel channel, byte[] bytes) throws IOException;
}
