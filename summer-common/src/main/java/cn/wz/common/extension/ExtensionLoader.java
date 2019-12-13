package cn.wz.common.extension;

import cn.wz.common.exception.SummerFrameworkException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * spi扩展类
 * @Author: wz
 */
public class ExtensionLoader<T> {

    /**
     * 做本地缓存提升性能
     */
    private static ConcurrentMap<Class<?>, ExtensionLoader<?>> extensionLoaders = new ConcurrentHashMap<>();

    public static <T> ExtensionLoader<T> getExtensionLoader(Class type) {
        //校验类型是否正确
        checkInterface(type);
        ExtensionLoader<T> loader = (ExtensionLoader<T>) extensionLoaders.get(type);
        if (loader == null) {
            loader = initExtensionLoader(type);
        }
        return loader;
    }

    private static synchronized <T> ExtensionLoader<T> initExtensionLoader(Class type) {

    }




    private static void checkInterface(Class clazz) {
        if (clazz == null) {
            throw new SummerFrameworkException("Error exception type is null");
        }
        if (!clazz.isInterface()) {
            throw new SummerFrameworkException("Error exception type is not interface");
        }
    }
}
