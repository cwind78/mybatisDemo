package com.mysql.mybatis.test.demo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MthdParameterLogger {
    boolean isResultLogging() default false;
    boolean isArgumentLogging() default true;
}