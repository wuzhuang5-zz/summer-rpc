package cn.wz.switcher;

public class Switcher {

    private boolean on = true;
    //开关名
    private String name;

    public Switcher(boolean on, String name) {
        this.on = on;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    //打开开关
    public void onSwitcher() {
        this.on = true;
    }
    //关闭开关
    public void offSwitcher() {
        this.on = false;
    }
}
