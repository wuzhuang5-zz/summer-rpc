package com.summer.registry;

import com.summer.protocol.URL;

public interface Registry extends RegistryService, DiscoveryService{
    URL getUrl();
}
