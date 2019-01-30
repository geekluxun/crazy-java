package com.geekluxun.design.patterns.strategy;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:42
 * @Description:
 * @Other:
 */
public class Person {
    private Travel travel;

    public Person(Travel travel){
        this.travel = travel;
    }
    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public void travel(){
        travel.travel();
    }
}
