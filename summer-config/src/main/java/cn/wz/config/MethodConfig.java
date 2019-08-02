package cn.wz.config;

/**
 * 方法配置
 * @author wz
 */
public class MethodConfig {
    /**
     * 方法名
     */
    private String name;
    /**
     * 超时时间
     */
    private Integer requestTimeout;
    public void setName(String name) {
        this.name = name;
    }
}
