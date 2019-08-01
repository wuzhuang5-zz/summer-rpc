package cn.wz.config;

public class RegistryConfig {
    /**
     * 注册中心名
     */
    private String regProtocol;
    /**
     * 注册中心地址 ip:port
     */
    private String address;


    public void setRegProtocol(String regProtocol) {
        this.regProtocol = regProtocol;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
