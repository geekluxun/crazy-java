package com.geekluxun.apache.commons.lang.builder;

import lombok.Data;
import org.apache.commons.lang3.builder.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 14:58
 * @Description:
 * @Other:
 */
@Data
public class Child extends Parent{
    private String cf1;
    private String cf2;
    // 排除toString中
    @ToStringExclude
    private Integer value3;

    /**
     * 必须调用super.toString才能打印Parent中pf1字段!!!
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}