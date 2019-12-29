package cn.wz.common.log;

public interface LogService {

    void debug(String msg);

    void debug(String format, Object... argArray);

    void debug(String msg, Throwable t);

    void info(String msg);

    void info(String format, Object... argArray);

    void info(String msg, Throwable t);

    void warn(String msg);

    void warn(String format, Object... argArray);

    void warn(String msg, Throwable t);

    void error(String msg);

    void error(String format, Object... argArray);

    void error(String msg, Throwable t);


    boolean isDebugEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();

}
