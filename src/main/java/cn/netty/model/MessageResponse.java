package cn.netty.model;

import lombok.Data;

/**
 * 服务应答消息
 * @author wz
 */
@Data
public class MessageResponse {
    /**
     * 标识唯一请求id
     */
    private String requestId;
    /**
     * 返回状态码
     */
    private Integer statusCode;
    /**
     * 响应数据
     */
    private Object rpcResponse;
}
