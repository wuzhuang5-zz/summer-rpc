package cn.wz.rpc;

public class URL {
    /**
     * 协议名
     */
    private String protocol;
    /**
     * ip地址
     */
    private String host;
    /**
     * 端口
     */
    private int port;

    public String getProtocol() {
        return protocol;
    }

    public URL(String protocol, String host, int port, String path) {
    }
    public URL() {

    }
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
