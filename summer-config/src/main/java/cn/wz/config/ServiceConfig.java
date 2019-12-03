package cn.wz.config;

import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.common.log.LoggerUtil;
import cn.wz.rpc.URL;
import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.util.List;

/**
 * @author wz
 */
public class ServiceConfig<T> {

    private Class<T> interfaceClass;

    private String group;

    private String version;

    /**
     * 实现类
     */
    private T ref;

    /**
     * todo 支持注册中心列表 暂时先只支持一个
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

    private List<MethodConfig> methodConfigs;

    /**
     * 暴露服务，检查配置
     */
    public synchronized void export() {

        //校验接口和方法
        checkInterfaceAndMethods(interfaceClass, methodConfigs);

        //获取注册中心URL   (protocol ip port)
        if (registryConfig == null) {
            throw new IllegalStateException("Should set registry config for service:" + interfaceClass.getName());
        }
        //验证rpc 协议和端口
        if (StringUtils.isBlank(export)) {
            throw new SummerFrameworkException("export should not empty in service config" + interfaceClass.getName());
        }
//        protocolConfig.setName(export);
        //todo 兼容其他协议 暂时先用summer
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            String serviceUrl = new URL(export.split(":")[0], host, Integer.parseInt(export.split(":")[1]), interfaceClass.getName()).toString();
            ConfigHandler.export(interfaceClass,serviceUrl, registryConfig);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.error("summer export service has exception");
        }
    }

    private void checkInterfaceAndMethods(Class<?> interfaceClass, List<MethodConfig> methods) {
        if (interfaceClass == null) {
            throw new IllegalStateException("interface not allow null");
        }
        if (!interfaceClass.isInterface()) {
            throw new IllegalStateException("The interface" + interfaceClass.getName() + "is not interface");
        }
        //检查方法是否在接口中存在 TODO
    }


    public void setVersion(String version) {
        this.version = version;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
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


    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }
}
