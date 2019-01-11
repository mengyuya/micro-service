package com.asus.orderservice.common.enums;

public enum FlagType {

    EFFECTIVE("生效", 1),
    INEFFECTIVE("失效", 2);

    //中文名称
    private String name;
    //编码
    private int code;

    private FlagType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public static FlagType getEnum(int code) {
        for (FlagType emu : FlagType.values()) {
            if (emu.code == code) {
                return emu;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
