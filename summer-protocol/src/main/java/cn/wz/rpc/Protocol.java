package cn.wz.rpc;

public interface Protocol {
    <T> Exporter export(Provider<T> provider, URL url);
}
