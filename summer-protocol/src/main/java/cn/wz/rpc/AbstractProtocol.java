package cn.wz.rpc;

import cn.wz.common.exception.SummerFrameworkException;

public class AbstractProtocol implements Protocol{
    @Override
    public <T> Exporter export(Provider<T> provider, URL url) {
        if (url == null) {
            throw new SummerFrameworkException(this.getClass().getSimpleName() + "export error: url is null");
        }
        return null;
    }
}
