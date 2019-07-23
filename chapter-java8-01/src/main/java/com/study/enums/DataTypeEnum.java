package com.study.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luhonggang
 */

public enum DataTypeEnum{

    TEXT(1, "文本"),
    NUMERICAL(2, "数值");

    private final Integer value;
    private final String desc;


    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


    public boolean matches(Integer value) {
        if (null == value) {
            return false;
        }
        return getValue().intValue() == value.intValue();
    }


    DataTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Integer, DataTypeEnum> mappings = new HashMap<>();

    static {
        Arrays.stream(DataTypeEnum.values())
                .forEach(dataTypeEnum -> mappings.put(dataTypeEnum.getValue(), dataTypeEnum));

    }

    public static DataTypeEnum resolve(Integer dataType) {
        return mappings.get(dataType);
    }

}
