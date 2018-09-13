package cn.summer.registry;

import java.net.URL;

public interface RegistryFactory {

    Registry getRegistry(URL url);

}
