package cn.wz.config;

import cn.wz.register.Register;
import cn.wz.register.ZookeeperRegister;

/**
 * @Author: wz
 */
public class ConfigHandler {

    public static void export(Class<?> interfaceClass, RegistryConfig registryConfig) {
        //todo export
        String address = registryConfig.getAddress();
        Register register = new ZookeeperRegister();
    }
}
