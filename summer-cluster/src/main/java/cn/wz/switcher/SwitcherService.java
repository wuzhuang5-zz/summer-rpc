package cn.wz.switcher;

import java.util.List;

/**
 * 开关接口
 */

public interface SwitcherService {
    /**
     * 获取接口降级开关
     * @param name
     * @return
     */
    Switcher getSwitcher(String name);

    /**
     * 获取所有接口降级开关
     * @return
     */
    List<Switcher> getSwitchers();

    /**
     * 初始化开关
     * @param switcherName
     * @param initialValue
     */
    void initSwitcher(String switcherName, boolean initialValue);

    /**
     * 检查开关是否已开启
     * @param switcherName
     * @return
     */
    boolean isOpen(String switcherName);

    /**
     * 设置开关状态
     * @param switcherName
     * @param value
     */
    void setValue(String switcherName, boolean value);
}
