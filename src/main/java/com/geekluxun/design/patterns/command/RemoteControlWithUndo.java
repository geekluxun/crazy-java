package com.geekluxun.design.patterns.command;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 17:09
 * @Description: 命令模式中的invoker
 * @Other:
 */
public class RemoteControlWithUndo {
    private Command[] onCommand;
    private Command[] offCommand;
    private Command undoCommand;


    public RemoteControlWithUndo() {
        /**
         * 初始化所有命令
         */
        onCommand = new Command[10];
        offCommand = new Command[10];
        for (int i = 0; i < 10; i++) {
            onCommand[i] = new NoCommand();
            offCommand[i] = new NoCommand();
        }
        undoCommand = new NoCommand();
    }

    /**
     * 设置某一个插槽的命令
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int slot , Command onCommand , Command offCommand){
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    /**
     * 按开按钮
     *
     * @param slot
     */
    public void onButtonWasPushed(int slot) {
        onCommand[slot].execute();
        /**
         * 保存当前命令用作撤销
         */
        undoCommand = onCommand[slot];
    }

    /**
     * 按关按钮
     *
     * @param slot
     */
    public void offButtonWasPushed(int slot) {
        offCommand[slot].execute();
        /**
         * 保存当前命令用作撤销
         */
        undoCommand = onCommand[slot];
    }

    /**
     * 撤销前一个按钮命令
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
