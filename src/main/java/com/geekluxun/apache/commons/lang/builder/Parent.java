package com.geekluxun.apache.commons.lang.builder;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 14:58
 * @Description:
 * @Other:
 */
@Data
public  class Parent implements Serializable {
    private String pf1;

    @Override
    public String toString() {
        super.toString();
        //return  new ReflectionToStringBuilder(this, new RecursiveToStringStyle()).toString();
        return   ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        //return ReflectionToStringBuilder.toString(this); 
    }
}
