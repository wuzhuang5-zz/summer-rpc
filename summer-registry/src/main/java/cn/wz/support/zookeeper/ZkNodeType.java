package cn.wz.support.zookeeper;

public enum ZkNodeType {
    /**
     * 可用节点
     */
    AVAILABLE_SERVER("server"),
    /**
     * 不可用节点
     */
    UNAVAILABLE_SERVER("unavailableServer"),
    /**
     * 客户端
     */
    CLIENT("client");

    private String value;

    private ZkNodeType(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
 }
