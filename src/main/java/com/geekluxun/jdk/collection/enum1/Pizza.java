package com.geekluxun.jdk.collection.enum1;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: luxun
 * @Create: 2018-11-02 16:52
 * @Description:
 * @Other:
 */
public class Pizza {

    private static EnumSet<PizzaStatusEnum> deliveredPizzaStatuses = EnumSet.of(PizzaStatusEnum.DELIVERED);
    private PizzaStatusEnum status;

    public enum PizzaStatusEnum {

        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },

        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        public int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        PizzaStatusEnum(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }
    }

    public PizzaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PizzaStatusEnum status) {
        this.status = status;
    }


    public boolean isDeliverable() {
        return this.status.isReady();
    }

    /**
     * 所有没有发送的披萨
     * @param input
     * @return
     */
    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        // 过滤完转换成List
        return input.stream().filter((a) -> !deliveredPizzaStatuses.contains(a.getStatus())).collect(Collectors.toList());
    }

    /**
     * 按照披萨状态分组
     *
     * @param pzList
     * @return
     */
    public static EnumMap<PizzaStatusEnum, List<Pizza>> groupPizzaByStatus(List<Pizza> pzList) {
        return pzList.stream().collect(Collectors.groupingBy(Pizza::getStatus, () -> new EnumMap<>(PizzaStatusEnum.class), Collectors.toList()));
    }


    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatusEnum.DELIVERED);
        }
    }
}