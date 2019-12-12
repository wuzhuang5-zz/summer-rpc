package cn.wz.netty.serializtion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;

/**
 * @Author: wz
 */
public class FastJsonSerialization implements Serialization {

    @Override
    public byte[] serialize(Object data) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter();
        JSONSerializer jsonSerializer = new JSONSerializer(serializeWriter);
        jsonSerializer.config(SerializerFeature.WriteEnumUsingToString, true);
        jsonSerializer.config(SerializerFeature.WriteClassName, true);
        jsonSerializer.write(data);
        return serializeWriter.toBytes("UTF-8");
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(new String(bytes), clazz);
    }
}
