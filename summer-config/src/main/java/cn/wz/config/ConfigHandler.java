package cn.wz.config;

import cn.wz.register.Register;
import cn.wz.register.RegisterFactory;
import cn.wz.rpc.Exporter;
import cn.wz.rpc.URL;

import java.net.UnknownHostException;

/**
 * @Author: wz
 */
public class ConfigHandler {

    public static void export(Class<?> interfaceClass, String serverUrl, RegistryConfig registryConfig) throws UnknownHostException {
        //todo export
        Exporter exporter


        //register service
        URL registerUrl = new URL(registryConfig.getRegProtocol(), registryConfig.getAddress().split(":")[0],
                Integer.parseInt(registryConfig.getAddress().split(":")[1]), interfaceClass.getName());
        Register register = RegisterFactory.createRegister(serverUrl, registerUrl);
        register.register(registerUrl);
    }
}
