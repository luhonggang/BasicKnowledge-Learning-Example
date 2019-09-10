package com.example.enums;

/**
 * 类型枚举
 * @author luhonggang
 */
public enum PayType {
    /**
     * ODEO 渠道
     */
    ODEO("1"),
    /**
     * wayanypay 渠道
     */
    WAYANYPAY("2");

    private  String value;

    PayType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
