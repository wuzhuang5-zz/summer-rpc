package cn.wz.rpc;

import cn.wz.common.util.SummerConstans;

/**
 * @author wz
 */
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

    /**
     * 包名路径
     */
    private String path;

    public String getProtocol() {
        return protocol;
    }

    public URL() {}

    public URL(String protocol, String host, int port, String path) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return protocol + SummerConstans.PROTOCOL_SEPARATOR + host + ":" + port + SummerConstans.PATH_SEPARATOR + path + "?group=summerrpc";
    }
}
