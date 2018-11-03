package com.geekluxun.jdk.collection.enum1;

/**
 * @Author: luxun
 * @Create: 2018-11-03 11:39
 * @Description:
 * @Other:
 */
public enum PizzaDeliveryStrategy {
    EXPRESS {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in express mode");
        }
    },
    NORMAL {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    };

    public abstract void deliver(Pizza pz);
}
