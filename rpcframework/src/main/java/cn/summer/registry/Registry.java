package cn.summer.registry;

import cn.summer.protocol.URL;

public interface Registry extends RegistryService, DiscoveryService{
    URL getUrl();
}
