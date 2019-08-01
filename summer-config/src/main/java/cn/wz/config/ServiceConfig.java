package cn.wz.config;

/**
 * @author wz
 */
public class ServiceConfig<T> {
    /**
     * 接口
     */
    Class<T> interfaceClass;

    /**
     * 服务实现类
     */
    private T ref;

    /**
     * 分组
     */
    private String group;
    /**
     * 版本号
     */
    private String version;
    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig;
    /**
     * 协议配置
     */
    private ProtocolConfig protocolConfig;
    /**
     * 协议端口  （protocol+port）
     */
    private String export;

    public synchronized void export(){

    }
    public void setVersion(String version) {
        this.version = version;
    }
    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setRegistryConfig(RegistryConfig registryConfig) {
        this.registryConfig = registryConfig;
    }

    public void setProtocolConfig(ProtocolConfig protocolConfig) {
        this.protocolConfig = protocolConfig;
    }

    public void setExport(String export) {
        this.export = export;
    }
}
