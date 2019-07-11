package cn.wz.rpc;

import java.util.Map;

public interface Request{
    String getInterfaceName();

    String getMethodName();

    String getParamtersDesc();

    Object[] getArguments();

    Map<String, String> getAttachments();

    void setAttachment(String name, String value);

    long getRequestId();

    int getRetries();

    void setRetries(int retries);

    void setRpcProtocolVersion(byte rpcProtocolVersion);

    byte getRpcProtocolVersion();
}
