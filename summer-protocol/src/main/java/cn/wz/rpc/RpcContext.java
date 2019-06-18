package cn.wz.rpc;

import java.util.HashMap;
import java.util.Map;

public class RpcContext {
    private static final ThreadLocal<RpcContext> LOCAL_CONTEXT = new ThreadLocal<RpcContext>(){
        //匿名类
        @Override
        protected RpcContext initialValue() {
            return new RpcContext();
        }
    };
    private Map<Object, Object> attributes = new HashMap<>();
    private Map<String, String> attachments = new HashMap<>();
    private Request request;
    private Response response;
    private String clientRequestId = null;


    public static RpcContext getRpcContext() {
        return LOCAL_CONTEXT.get();
    }

    /**
     * 根据request初始化rpcContext
     * @param request
     * @return
     */
    public static RpcContext init(Request request) {
        RpcContext rpcContext = new RpcContext();
        if(request != null) {
            rpcContext.setRequest(request);
            rpcContext.setClientRequestId(request.get);
        }
    }
    public void setAttributes(Object key, Object value) {
        attributes.put(key, value);
    }
    public Object getAttributes(Object key) {
        return attributes.get(key);
    }
    public void setAttachments(String key, String value) {
        attachments.put(key, value);
    }
    public String getAttachments(String key) {
        return attachments.get(key);
    }
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }
}
