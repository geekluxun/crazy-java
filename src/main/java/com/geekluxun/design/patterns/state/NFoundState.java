package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:59
 * @Description:
 * @Other:
 */
public class NFoundState implements State {
    private WordStateMachine stateMachine;


    public NFoundState(WordStateMachine machine) {
        stateMachine = machine;
    }

    @Override
    public void inputWord(Character word) {
        if (word.equals('i')) {
            stateMachine.setState(stateMachine.getiFoundState());
        } else {
            stateMachine.setState(stateMachine.getErrorState());
        }
    }

    @Override
    public String getStateName() {
        return "字符n状态";
    }

}
