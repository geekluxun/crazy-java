package com.geekluxun.design.patterns.state;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:48
 * @Description:
 * @Other:
 */
public interface State {
    /**
     * 每一个状态收到一个单词时，都会根据输入决定状态机的下一个状态是什么
     * @param word
     */
    void inputWord(Character word);

    String getStateName();
}
