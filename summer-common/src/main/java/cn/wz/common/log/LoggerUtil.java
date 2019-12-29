package cn.wz.common.log;

public class LoggerUtil {
    private static LogService logService = new DefaultLogService();


    public static boolean isDebugEnabled() {
        return logService.isDebugEnabled();
    }

    public static boolean isWarnEnabled() {
        return logService.isWarnEnabled();
    }

    public static boolean isErrorEnabled() {
        return logService.isErrorEnabled();
    }

    public static void debug(String msg) {
        logService.debug(msg);
    }

    public static void debug(String format, Object... argArray) {
        logService.debug(format, argArray);
    }

    public static void debug(String msg, Throwable t) {
        logService.debug(msg, t);
    }

    public static void info(String msg) {
        logService.info(msg);
    }

    public static void info(String format, Object... argArray) {
        logService.info(format, argArray);
    }

    public static void info(String msg, Throwable t) {
        logService.info(msg, t);
    }

    public static void warn(String msg) {
        logService.warn(msg);
    }

    public static void warn(String format, Object... argArray) {
        logService.warn(format, argArray);
    }

    public static void warn(String msg, Throwable t) {
        logService.warn(msg, t);
    }

    public static void error(String msg) {
        logService.error(msg);
    }

    public static void error(String format, Object... argArray) {
        logService.error(format, argArray);
    }

    public static void error(String msg, Throwable t) {
        logService.error(msg, t);
    }


    public static LogService getLogService() {
        return logService;
    }

    public static void setLogService(LogService logService) {
        LoggerUtil.logService = logService;
    }

}
