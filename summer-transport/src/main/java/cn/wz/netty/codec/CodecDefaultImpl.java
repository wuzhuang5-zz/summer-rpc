package cn.wz.netty.codec;

import cn.wz.netty.Channel;
import cn.wz.rpc.Request;

import java.io.*;

/**
 * @Author: wz
 */
public class CodecDefaultImpl implements Codec {

    @Override
    public byte[] encode(Channel channel, Object message) throws IOException {
        if (message instanceof Request) {
            return encodeRequest(channel, (Request) message);
        }
        return new byte[0];
    }

    private byte[] encodeRequest(Channel channel, Request request) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(outputStream);
        out.writeUTF(request.getInterfaceName());
        out.writeUTF(request.getMethodName());
        out.writeUTF(request.getMethodDesc());
    }

    @Override
    public Object decode(Channel channel, byte[] bytes) throws IOException {
        //todo 数据校验  1、magic 2、version
        long requestId =
        return null;
    }

}
