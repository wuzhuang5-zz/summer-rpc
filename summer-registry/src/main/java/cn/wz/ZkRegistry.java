package cn.wz;

import org.I0Itec.zkclient.ZkClient;

public class ZkRegistry {
    public static void main(String[] args) {
        try {
            ZkClient zkClient = new ZkClient("127.0.0.1:2181", 5000);
            System.out.println("连接成功");
        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }
}
