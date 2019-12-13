package cn.wz.rpc;

import java.io.Serializable;

/**
 * @Author: wz
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 5488706565492544572L;

    private String interfaceName;

    private String methodName;

    /**
     * 参数
     */
    private Object[] arguments;

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    private String methodDesc;
    /**
     * 标识请求
     */
    private long requestId;
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }
}
