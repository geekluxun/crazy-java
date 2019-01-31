package com.geekluxun.design.patterns.chianOfResponsibility;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:36
 * @Description:
 * @Other:
 */
public class ConcreteHandler1 implements Hanlder {
    private Hanlder nextHandler;

    public ConcreteHandler1(Hanlder nextHandler) {
        this.nextHandler = nextHandler;
    }

    public ConcreteHandler1() {

    }

    public void setNextHandler(Hanlder hanlder) {
        nextHandler = hanlder;
    }

    @Override
    public Hanlder nextHandler() {
        return nextHandler;
    }

    @Override
    public void handlerRequest() {
        System.out.println("处理器1处理请求");
        if (nextHandler != null) {
            nextHandler.handlerRequest();
        }
    }

}
