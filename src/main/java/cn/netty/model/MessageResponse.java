package cn.netty.model;

import lombok.Data;

/**
 * 服务应答消息
 * @author wz
 */
@Data
public class MessageResponse {
    private String requestId;
    private Integer statusCode;
    private Object rpcResponse;
}
