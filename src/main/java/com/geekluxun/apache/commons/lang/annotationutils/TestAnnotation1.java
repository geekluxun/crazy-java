package com.geekluxun.apache.commons.lang.annotationutils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-06 15:11
 * @Description:
 * @Other:
 */

@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation1 {
    String value() default "test";

    String attribute1() default "luxun";
}
