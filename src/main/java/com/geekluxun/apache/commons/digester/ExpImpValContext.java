package com.geekluxun.apache.commons.digester;

import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 16:33
 * @Description:
 * @Other:
 */
@ObjectCreate(pattern = "validators")
public class ExpImpValContext {

    private List<ExpImpValHeader> headers = new ArrayList<ExpImpValHeader>();

    @SetNext
    public void addHeader(ExpImpValHeader header) {
        this.headers.add(header);
    }

    public List<ExpImpValHeader> getHeaders() {
        return headers;
    }
}
