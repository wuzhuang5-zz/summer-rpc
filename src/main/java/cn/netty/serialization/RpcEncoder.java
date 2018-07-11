package cn.netty.serialization;

import cn.netty.model.MessageRequest;
import cn.netty.model.MessageResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 对消息进行序列化/编码
 * @author wz
 */
public class RpcEncoder extends MessageToByteEncoder {

    private static Object responseCacheName = null;
    private static byte[] responseCacheValue = null;
    private static Object requestCacheName = null;
    private static byte[] requestCacheValue = null;
    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass){
        this.genericClass = genericClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if(genericClass.equals(MessageResponse.class)){
            MessageResponse messageResponse = (MessageResponse) o;
            String requestId = messageResponse.getRequestId();
            messageResponse.setRequestId("");
            byte[] requestIdByte = requestId.getBytes();
            byte[] body = null;
        }
    }
}
