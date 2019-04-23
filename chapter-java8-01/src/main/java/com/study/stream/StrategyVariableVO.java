package com.study.stream;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyVariableVO {

    /**
     * 策略变量ID
     */
    private Long id;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 变量名称
     */
    private String name;

    /**
     * 变量数据类型（1：文本、2：数值）
     */
    private Integer dataType;

    /**
     * 变量默认值
     */
    private String defaultValue;

    /**
     * 变量描述
     */
    private String description;

}
