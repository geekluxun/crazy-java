package com.geekluxun.apache.commons.lang.AnnotationUtils;

import java.lang.annotation.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-06 15:11
 * @Description:
 * @Other:
 */
@Documented
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.TYPE_USE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation2 {
    String value() default "test";
    String attribute1() default "luxun";
}
