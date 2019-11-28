package cn.wz.register;

/**
 * @Author: wz
 */
public interface RegisterFactory {
    /**
     * 生产注册中心
     * @param name
     * @return
     */
    Register createRegister(String name);
}
