package cn.wz.config;

import cn.wz.common.ParamType;
import cn.wz.common.exception.SummerFrameworkException;
import cn.wz.common.log.LoggerUtil;
import cn.wz.common.util.NetUtil;
import cn.wz.common.util.SummerConstans;
import cn.wz.rpc.URL;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
     * 注册中心列表 (应对多个注册中心)
     */
    private List<RegistryConfig> registryConfigs;
    /**
     * 协议配置
     */
    private ProtocolConfig protocolConfig;
    /**
     * 协议端口  （protocol+port）
     */
    private String export;

    private AtomicBoolean exported = new AtomicBoolean();

    private List<MethodConfig> methodConfigs;
    private String host;
    /**
     * 暴露服务，检查配置
     */
    public synchronized void export() {
        if (exported.get()) {
            LoggerUtil.warn(String.format("%s has already been expoted, so ignore the export request!", interfaceClass.getName()));
        }
        //校验接口和方法
        checkInterfaceAndMethods(interfaceClass, methodConfigs);

        //获取注册中心URL   (protocol ip port)
        List<URL> registerUrls = loadRegistryUrls();
        if (registerUrls == null || registerUrls.isEmpty()) {
            throw new IllegalStateException("Should set registry config for service:" + interfaceClass.getName());
        }
        //验证rpc 协议和端口
        if (StringUtils.isBlank(export)) {
            throw new SummerFrameworkException("export should not empty in service config" + interfaceClass.getName());
        }
        int port = Integer.valueOf(export.split(":")[0]);
        protocolConfig.setName(export);
        doExport(registerUrls, port, protocolConfig);
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

    private List<URL> loadRegistryUrls() {
        List<URL> registryList = new ArrayList<>();
        URL url = new URL();
        if (registryConfigs != null && !registryConfigs.isEmpty()) {
            for (RegistryConfig config : registryConfigs) {
                //ip:port
                String address = config.getAddress();
                if (StringUtils.isEmpty(address)) {
                    address = NetUtil.LOCALHOST + ":" + SummerConstans.DEFAULT_INT_VALUE;
                }
                url.setHost(address.split(":")[0]);
                url.setPort(Integer.valueOf(address.split(":")[1]));
                url.setProtocol(config.getRegProtocol());
            }
        }
        registryList.add(url);
        return registryList;
    }

    private void doExport(List<URL> registryList, int port, ProtocolConfig protocolConfig) {
        if (StringUtils.isBlank(protocolConfig.getName())) {
            protocolConfig.setName(ParamType.protocol.getValue());
        }
        URL serviceUrl = new URL(protocolConfig.getName(), host, port, );
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
