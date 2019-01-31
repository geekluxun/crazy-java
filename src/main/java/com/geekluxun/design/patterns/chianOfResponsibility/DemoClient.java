package com.geekluxun.design.patterns.chianOfResponsibility;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:41
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        Hanlder hanlder1 = new ConcreteHandler1();
        Hanlder hanlder2 = new ConcreteHandler2();
        Hanlder hanlder3 = new ConcreteHandler3();

        ((ConcreteHandler1) hanlder1).setNextHandler(hanlder2);
        ((ConcreteHandler2) hanlder2).setNextHandler(hanlder3);

        hanlder1.handlerRequest();
    }
}
