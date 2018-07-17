package com.geekluxun.apache.commons.digester;

import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetProperty;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 16:34
 * @Description:
 * @Other:
 */
@ObjectCreate(pattern = "validators/header/validator")
public class ExpImpValidator {

    @SetProperty(attributeName = "type", pattern = "validators/header/validator")
    private String type;
    @BeanPropertySetter(pattern = "validators/header/validator/className")
    private String className;
    @BeanPropertySetter(pattern = "validators/header/validator/filedName")
    private String filedName;
    @BeanPropertySetter(pattern = "validators/header/validator/methodName")
    private String methodName;
    @BeanPropertySetter(pattern = "validators/header/validator/reg")
    private String reg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

}  
