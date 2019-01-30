package com.geekluxun.design.patterns.command;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:58
 * @Description: 命令抽象
 * @Other:
 */
public interface Command {
    void execute();
    void undo();
}
