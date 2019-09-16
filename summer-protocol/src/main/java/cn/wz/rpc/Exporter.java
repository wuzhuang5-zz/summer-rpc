package cn.wz.rpc;

/**
 * Exporter模型
 * @param <T>
 */
public interface Exporter<T> extends Node{

    Provider<T> getProvider();

    void unexport();
}
