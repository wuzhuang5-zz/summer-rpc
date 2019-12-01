package cn.wz.config;

import cn.wz.register.Register;
import cn.wz.register.RegisterFactory;
import cn.wz.rpc.URL;

/**
 * @Author: wz
 */
public class ConfigHandler {

    public static void export(Class<?> interfaceClass, RegistryConfig registryConfig) {
        //todo export
        String address = registryConfig.getAddress();
        URL url = new URL(registryConfig.getRegProtocol(), address.split(":")[0],
                Integer.parseInt(address.split(":")[1]), interfaceClass.getName());
        Register register = RegisterFactory.createRegister(url);
        register.register(url);
    }
}
