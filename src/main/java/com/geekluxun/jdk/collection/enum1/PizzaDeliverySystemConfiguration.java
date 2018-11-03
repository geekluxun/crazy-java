package com.geekluxun.jdk.collection.enum1;

/**
 * @Author: luxun
 * @Create: 2018-11-03 11:42
 * @Description:
 * @Other:
 */
public enum PizzaDeliverySystemConfiguration {
    INSTANCE;

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    PizzaDeliverySystemConfiguration(){

    }

    public static PizzaDeliverySystemConfiguration getInstance(){
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
