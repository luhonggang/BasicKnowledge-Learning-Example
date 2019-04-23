package com.study.stream;

import lombok.*;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/4/17 14:04
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentionSource {

    /**
     * 引用ID
     */
    private String id;
    /**
     * 变量名称（拼接了前缀）
     */
    private String name;
    /**
     * 变量数据类型（1：文本、2：数值）
     */
    private Integer dataType;
    /**
     * 引用变量类型（1：策略自定义变量、2：策略组件输出变量、3：变量池变量）
     */
    private Integer refType;
    /**
     * @前缀需要的字段
     */
    private String key;
    /**
     * @前缀需要的字段
     */
    private String value;

}
