package cn.wz.common;

public enum ParamType {
    protocol("protocol", "summer");


    private String name;
    private String value;
    private ParamType(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }
}
