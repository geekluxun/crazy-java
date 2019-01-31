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
    void inputWord(Character word);

    String getStateName();
}
