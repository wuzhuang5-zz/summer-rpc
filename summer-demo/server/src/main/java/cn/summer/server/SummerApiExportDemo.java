package cn.summer.server;

import cn.summer.service.SummerDemoService;
import cn.wz.config.ProtocolConfig;
import cn.wz.config.RegistryConfig;
import cn.wz.config.ServiceConfig;

/**
 * @author wz
 */
public class SummerApiExportDemo {
    public static void main(String[] args) {
        ServiceConfig<SummerDemoService> serviceConfig = new ServiceConfig<>();

        //设置接口及实现类
        serviceConfig.setInterfaceClass(SummerDemoService.class);
        serviceConfig.setRef(new SummerDemoServiceImpl());

        //设置服务的group和版本号
        serviceConfig.setGroup("summer-rpc");
        serviceConfig.setVersion("v1.0");

        //配置注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setRegProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        serviceConfig.setRegistryConfig(registryConfig);

        //配置rpc协议  (默认summer协议)
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setId("summer");
        protocolConfig.setName("summer");
        serviceConfig.setProtocolConfig(protocolConfig);

        //配置export
        serviceConfig.setExport("summer: 2233");
        serviceConfig.export();
    }
}
