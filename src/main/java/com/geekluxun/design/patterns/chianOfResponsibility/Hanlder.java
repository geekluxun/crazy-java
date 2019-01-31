package com.geekluxun.design.patterns.chianOfResponsibility;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:34
 * @Description:
 * @Other:
 */
public interface Hanlder {
    Hanlder nextHandler();

    void handlerRequest();
}
