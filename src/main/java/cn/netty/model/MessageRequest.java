package cn.netty.model;


import java.io.Serializable;

/**
 * 服务请求消息
 * @author wz
 */
public class MessageRequest implements Serializable {
    private static final long serialVersionUID = -5097523035983632908L;
    /**
     * 标识唯一请求id
     */
    private String requestId;
    /**
     * 接口名
     */
    private String interfaceName;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数
     */
    private Object[] parameters;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;
}
