package cn.wz.rpc;

/**
 * rpc上下文
 * @Author: wz
 */
public class RpcContext {

    private Request request;
    private Response response;
    /**
     * 根据请求初始化
     * @param request
     * @return
     */
    public static RpcContext init(Request request) {
        RpcContext rpcContext = new RpcContext();
        if (request != null) {
            rpcContext.setRequest(request);
        }
        return rpcContext;
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

}
