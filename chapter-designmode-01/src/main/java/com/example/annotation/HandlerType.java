package com.example.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited
public @interface HandlerType {
    /**
     * 类型code
     * @return value()
     */
    String value();

    /**
     * 渠道名称
     * @return name()
     */
    String name() default "";
}
