package cn.wz.rpc;

/**
 * @Description: 导出者
 * @Author: wz
 */
public interface Exporter {
    /**
     *
     * @param interfaceClass  生产者接口的Class对象
     * @param url  生产者host和端口和协议
     * @param ref  生产者实现类引用
     * @param <T>
     */
    public <T>void export(Class<T> interfaceClass, URL url, T ref);
}
