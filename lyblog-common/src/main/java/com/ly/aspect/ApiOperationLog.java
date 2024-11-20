package com.ly.aspect;

import java.lang.annotation.*;

/**
 * @Author: dly
 * @Date: 2024-11-19-22:57
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiOperationLog {
    /*
    * API 描述
    *
    * @return
    * */
    String description() default "";
}
