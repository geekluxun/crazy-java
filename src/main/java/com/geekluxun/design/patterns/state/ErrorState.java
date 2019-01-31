package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 11:04
 * @Description:
 * @Other:
 */
public class ErrorState implements State {
    private WordStateMachine stateMachine;


    public ErrorState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        System.out.println("已经进入错误状态...请不要再输入字符");
    }

    @Override
    public String getStateName() {
        return "error状态";
    }
}
