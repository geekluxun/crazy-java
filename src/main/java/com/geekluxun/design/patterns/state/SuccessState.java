package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:59
 * @Description:
 * @Other:
 */
public class SuccessState implements State {
    private WordStateMachine stateMachine;


    public SuccessState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        System.out.println("已经进入成功状态,请不要再输入字符...");
    }

    @Override
    public String getStateName() {
        return "success状态";
    }
}
