package com.geekluxun.effectivejava.chapter2.item2.builder;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-15 11:04
 * @Description: 使用构建器来实例化一个类
 * @Other:
 */
// Builder Pattern  (Page 13)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        /**
         * 必选字段（域）
         *
         * @param servingSize
         * @param servings
         */
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        /**
         * 这个build方法来构造outer类示例
         *
         * @return
         */
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    /**
     * 可以在静态方法中实例化一个static类
     *
     * @param args
     */
    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println("cocaCola:" + cocaCola);
    }
}