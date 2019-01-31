package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:59
 * @Description:
 * @Other:
 */
public class IFoundState implements State {

    private WordStateMachine stateMachine;


    public IFoundState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        if (word.equals('c')) {
            stateMachine.setState(stateMachine.getcFoundState());
        } else {
            stateMachine.setState(stateMachine.getErrorState());
        }
    }

    @Override
    public String getStateName() {
        return "字符i状态";
    }
}
