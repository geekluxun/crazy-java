package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:58
 * @Description:
 * @Other:
 */
public class StartState implements State {
    private WordStateMachine stateMachine;


    public StartState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        if (word.equals('n')) {
            stateMachine.setState(stateMachine.getnFoundState());
        } else {
            stateMachine.setState(stateMachine.getErrorState());
        }
    }

    @Override
    public String getStateName() {
        return "state状态";
    }
}
