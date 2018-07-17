package com.geekluxun.apache.commons.digester;

import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;
import org.apache.commons.digester3.annotations.rules.SetProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 16:34
 * @Description:
 * @Other:
 */
@ObjectCreate(pattern = "validators/header")
public class ExpImpValHeader {

    @SetProperty(attributeName = "name", pattern = "validators/header")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<ExpImpValidator> validators = new ArrayList<ExpImpValidator>();

    @SetNext
    public void addValidator(ExpImpValidator validator) {
        this.validators.add(validator);
    }

    public List<ExpImpValidator> getValidators() {
        return validators;
    }
}
