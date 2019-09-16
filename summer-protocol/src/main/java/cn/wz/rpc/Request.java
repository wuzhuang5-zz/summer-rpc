package cn.wz.rpc;

import java.util.Map;

public interface Request{
    /**
     * 获取接口名
     * @return
     */
    String getInterfaceName();

    /**
     * 获取方法名
     * @return
     */
    String getMethodName();

    /**
     * 获取参数描述
     * @return
     */
    String getParamtersDesc();

    /**
     * 获取参数
     * @return
     */
    Object[] getArguments();


    Map<String, String> getAttachments();

    void setAttachment(String name, String value);

    long getRequestId();

    int getRetries();

    void setRetries(int retries);

    void setRpcProtocolVersion(byte rpcProtocolVersion);

    byte getRpcProtocolVersion();
}
