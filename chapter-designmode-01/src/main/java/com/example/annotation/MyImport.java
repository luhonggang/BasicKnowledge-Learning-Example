package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 指定注解使用的场景 -> 类上-TYPE 方法上-METHOD 属性上-FIELD  等
 * @Retention 指定注解的生命周期 -> 定义注解的生命周期是在RetentionPolicy.SOURCE阶段(java源文件阶段),
 * 还是在RetentionPolicy.CLASS阶段(class文件阶段)，或者是在RetentionPolicy.RUNTIME阶段(内存中的字节码运行时阶段)
 *
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface MyImport {
    Class<?>[] value();
}
