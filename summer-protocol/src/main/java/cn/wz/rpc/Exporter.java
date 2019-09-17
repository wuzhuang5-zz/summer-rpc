package cn.wz.rpc;

/**
 * Exporter模型
 * @param <T>
 */
public interface Exporter<T> extends Node{

    public abstract Provider<T> getProvider();

    public abstract void unexport();
}
