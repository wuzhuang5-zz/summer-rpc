package cn.wz.rpc;

/**
 * 协议领域模型
 */
public interface Protocol {
    /**
     * 暴露服务
     * @param provider 提供服务者
     * @param url
     * @param <T>
     * @return
     */
    <T> Exporter export(Provider<T> provider, URL url);

}
