package cn.wz.common.extension;

import cn.wz.common.exception.SummerFrameworkException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * spi扩展类
 *
 * @Author: wz
 */
public class ExtensionLoader<T> {
    /**
     * 做本地缓存提升性能
     */
    private static ConcurrentMap<Class<?>, ExtensionLoader<?>> extensionLoaders = new ConcurrentHashMap<>();

    private ConcurrentMap<String, Class<T>> extensionClasses = null;

    public static final String PREFIX = "META-INF/services/";

    private Class<T> type;

    private ClassLoader classLoader;
    /**
     * 是否初始化
     */
    private volatile boolean init = false;

    /**
     * 获取本类
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T> ExtensionLoader<T> getExtensionLoader(Class type) {
        //校验类型是否正确
        checkInterface(type);
        ExtensionLoader<T> loader = (ExtensionLoader<T>) extensionLoaders.get(type);
        if (loader == null) {
            loader = initExtensionLoader(type);
        }
        return loader;
    }

    public T getExtension(String name) {
        if (!init) {
           extensionClasses = loadExtensionClasses(PREFIX);
        }
        return null;
//        return extensionClasses.getClass();
    }


    private synchronized ConcurrentMap<String, Class<T>> loadExtensionClasses(String prefix) {
        String fullName = prefix + type.getName();
        List<String> ClassNames = new ArrayList<>();
        try {
            Enumeration<URL> urls;
            if (classLoader == null) {
                urls = ClassLoader.getSystemResources(fullName);
            } else {
                urls = classLoader.getResources(fullName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static synchronized <T> ExtensionLoader<T> initExtensionLoader(Class type) {
        ExtensionLoader<T> loader = new ExtensionLoader<>();
        extensionLoaders.putIfAbsent(type, loader);
        return loader;
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
