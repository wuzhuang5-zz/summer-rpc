package cn.wz.common.extension;

import cn.wz.common.exception.SummerFrameworkException;

/**
 * @Author: wz
 */
public class ExtensionLoader<T> {

    public static <T> ExtensionLoader getExtensionLoader(Class type) {
        checkInterface(type);
    }

    private static void checkInterface(Class clazz) {
        if (clazz == null) {
            throw new SummerFrameworkException("Error exception type is null");
        }

    }
}
