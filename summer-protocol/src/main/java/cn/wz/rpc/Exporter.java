package cn.wz.rpc;

/**
 * Exporter领域模型 (导出者)
 * @param <T>
 */
public interface Exporter<T> {

    Provider<T> getProvider();

    void unexport();
}
