package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:50
 * @Description: 单词识别状态机
 * @Other:
 */
public class WordStateMachine {
    /**
     * 状态机拥有的所有的状态
     */
    private State startState;
    private State nFoundState;
    private State iFoundState;
    private State cFoundState;
    private State successState;
    private State errorState;

    /**
     * 当前的状态
     */
    private State state;

    public WordStateMachine() {
        /**
         * 每一个状态都持有状态机实例
         */
        startState = new StartState(this);
        nFoundState = new NFoundState(this);
        iFoundState = new IFoundState(this);
        cFoundState = new CFoundState(this);
        successState = new SuccessState(this);
        errorState = new ErrorState(this);
        state = startState;
    }

    public void inputWord(char word) {
        state.inputWord(word);
    }

    void setState(State state) {
        System.out.println("当前状态机状态:" + state);
        this.state = state;
        if (state.equals(errorState)) {
            System.out.println("进入了错误状态，退出状态机...");
            System.exit(-1);
        }

        if (state.equals(successState)) {
            System.out.println("进入了成功状态，结束状态机...");
            System.exit(0);
        }
    }

    public State getStartState() {
        return startState;
    }

    public State getnFoundState() {
        return nFoundState;
    }

    public State getiFoundState() {
        return iFoundState;
    }

    public State getcFoundState() {
        return cFoundState;
    }

    public State getSuccessState() {
        return successState;
    }

    public State getErrorState() {
        return errorState;
    }

    public State getState() {
        return state;
    }
}
