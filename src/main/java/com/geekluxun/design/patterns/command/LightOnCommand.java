package com.geekluxun.design.patterns.command;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 17:03
 * @Description:
 * @Other:
 */
public class LightOnCommand implements Command {
    
    private Light light;
    
    
    public LightOnCommand(Light light){
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
