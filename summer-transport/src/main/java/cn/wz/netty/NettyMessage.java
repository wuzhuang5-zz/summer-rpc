package cn.wz.netty;

/**
 * @Author: wz
 */
public class NettyMessage {

    private long requestId;

    private byte[] data;

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
