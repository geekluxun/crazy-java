package com.geekluxun.apache.commons.lang.annotationutils;

import java.lang.annotation.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-06 15:11
 * @Description:
 * @Other:
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@TestAnnotation1
public @interface TestAnnotation2 {
    String value() default "test";

    String attribute1() default "luxun";
}
