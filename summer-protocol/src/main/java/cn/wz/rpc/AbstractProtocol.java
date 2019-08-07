package cn.wz.rpc;

import cn.wz.common.exception.SummerFrameworkException;

/**
 * Protocol模型抽象实现类 (模板方法设计模式)
 */
public abstract class AbstractProtocol implements Protocol{
    @Override
    public <T> Exporter export(Provider<T> provider, URL url) {
        if (url == null) {
            throw new SummerFrameworkException(this.getClass().getSimpleName() + "export error: url is null");
        }
        if (provider == null) {
            throw new SummerFrameworkException(this.getClass().getSimpleName() + "export error: provider is null");
        }
        Exporter exporter = createExporter(provider, url);
        return null;
    }

    protected abstract <T> Exporter<T> createExporter(Provider<T> provider, URL url);

}
