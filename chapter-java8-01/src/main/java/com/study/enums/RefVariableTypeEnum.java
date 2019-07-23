package com.study.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 引用变量类型
 *
 * @author
 * @date 2019-01-14 5:44 PM
 */
public enum RefVariableTypeEnum  {

    STRATEGY_VARIABLE(1, "策略自定义变量", "s_", "s."),
    STRATEGY_ITEM_OUTPUT_VARIABLE(2, "策略组件输出变量", "m_", "m."),
    VARIABLE_POOL_VARIABLE(3, "变量池变量", "e_", "e.");

    private final Integer value;
    private final String desc;
    private final String ref;
    private final String prefix;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public String getRef() {
        return ref;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean matches(Integer value) {
        if (null == value) {
            return false;
        }
        return getValue().intValue() == value.intValue();
    }
    RefVariableTypeEnum(Integer value, String desc, String ref, String prefix) {
        this.value = value;
        this.desc = desc;
        this.ref = ref;
        this.prefix = prefix;
    }

    private static Map<Integer, RefVariableTypeEnum> mappings = new HashMap<>();

    static {
        Arrays.stream(RefVariableTypeEnum.values())
                .forEach(refVariableTypeEnum -> mappings.put(refVariableTypeEnum.getValue(), refVariableTypeEnum));

    }

    public static RefVariableTypeEnum resolve(Integer refType) {
        return mappings.get(refType);
    }

}
