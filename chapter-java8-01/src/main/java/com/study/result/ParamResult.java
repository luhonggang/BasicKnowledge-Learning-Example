package com.study.result;

import lombok.Data;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/8/28 17:33
 */
@Data
public class ParamResult<T> {
    private String code;
    private String message;
    T data;
}
