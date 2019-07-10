package cn.wz.rpc;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class DefaultRequest implements Request , Serializable{
    private static final long serialVersionUID = 6777332257932913864L;

    private String interfaceName;
    private String methodName;
    private String paramtersDesc;
    private Object[] arguments;
    private long requestId;

    @Override
    public Map<String, String> getAttachments() {
        return null;
    }

    @Override
    public void setAttachment(String name, String value) {

    }

    @Override
    public int getRetries() {
        return 0;
    }

    @Override
    public void setRetries(int retries) {

    }

    @Override
    public void setRpcProtocolVersion(byte rpcProtocolVersion) {

    }

    @Override
    public byte getRpcProtocolVersion() {
        return 0;
    }
}
