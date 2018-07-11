package cn.netty.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 服务请求消息
 * @author wz
 */
@Data
public class MessageRequest implements Serializable {
    private static final long serialVersionUID = -5097523035983632908L;
    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] parameterTypes;
}
