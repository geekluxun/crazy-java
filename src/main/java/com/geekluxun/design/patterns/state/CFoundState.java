package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:59
 * @Description:
 * @Other:
 */
public class CFoundState implements State {
    private WordStateMachine stateMachine;

    public CFoundState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        if (word.equals('e')) {
            stateMachine.setState(stateMachine.getSuccessState());
        } else {
            stateMachine.setState(stateMachine.getErrorState());
        }
    }

    @Override
    public String getStateName() {
        return "字符c状态";
    }
}
