package com.geekluxun.design.patterns.command;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 17:07
 * @Description:
 * @Other:
 */
public class LightOffCommand implements Command {
    private Light light;


    public LightOffCommand(Light light){
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
