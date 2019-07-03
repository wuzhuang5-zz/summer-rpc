package cn.wz;

import cn.wz.rpc.URL;

public interface RegistryService {
    /**
     * 注册服务
     * @param url
     */
    void register(URL url);

    /**
     *  摘除服务
     * @param url
     */
    void unRegister(URL url);

    /**
     * set service status to available, so clients could use it
     * @param url service url to be available, <b>null</b> means all services
     */
    void alailable(URL url);

    void unAlailable(URL url);
}
