package cn.wz.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultLogService implements LogService{
    private static Logger trace = LoggerFactory.getLogger("trace");
    private static Logger debug = LoggerFactory.getLogger("debug");
    private static Logger info = LoggerFactory.getLogger("info");
    private static Logger warn = LoggerFactory.getLogger("warn");
    private static Logger error = LoggerFactory.getLogger("error");
    private static Logger access = LoggerFactory.getLogger("accessLog");
    private static Logger serviceStats = LoggerFactory.getLogger("serviceStatsLog");
    private static Logger profileLogger = LoggerFactory.getLogger("profile");

    @Override
    public void trace(String msg) {
        trace.trace(msg);
    }

    @Override
    public void trace(String format, Object... argArray) {
        trace.trace(format, argArray);
    }
    @Override
    public void debug(String msg) {
        debug.debug(msg);
    }
    @Override
    public void debug(String format, Object... argArray) {
        debug.debug(format, argArray);
    }
    @Override
    public void debug(String msg, Throwable t) {
        debug.debug(msg, t);
    }
    @Override
    public void info(String msg) {
        info.info(msg);
    }
    @Override
    public void info(String format, Object... argArray) {
        info.info(format, argArray);
    }
    @Override
    public void info(String msg, Throwable t) {
        info.info(msg, t);
    }
    @Override
    public void warn(String msg) {
        warn.warn(msg);
    }
    @Override
    public void warn(String format, Object... argArray) {
        warn.warn(format, argArray);
    }
    @Override
    public void warn(String msg, Throwable t) {
        warn.warn(msg, t);
    }
    @Override
    public void error(String msg) {
        error.error(msg);
    }
    @Override
    public void error(String format, Object... argArray) {
        error.error(format, argArray);
    }
    @Override
    public void error(String msg, Throwable t) {
        error.error(msg, t);
    }
    @Override
    public void accessLog(String msg) {
        access.info(msg);
    }
    @Override
    public void accessStatsLog(String msg) {
        serviceStats.info(msg);
    }
    @Override
    public void accessStatsLog(String format, Object... argArray) {
        serviceStats.info(format, argArray);
    }
    @Override
    public void accessProfileLog(String format, Object... argArray) {
        profileLogger.info(format, argArray);
    }

    @Override
    public boolean isTraceEnabled() {
        return trace.isTraceEnabled();
    }

    @Override
    public boolean isDebugEnabled() {
        return debug.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return info.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return warn.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return error.isErrorEnabled();
    }

    @Override
    public boolean isStatsEnabled() {
        return serviceStats.isInfoEnabled();
    }


}

