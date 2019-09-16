package cn.wz.rpc;

/**
 * Provider/Referer 公共方法
 * @author wz
 */
public interface Node {

    void init();

    void destroy();

    String desc();

    URL getUrl();
}
