package com.geekluxun.common.exception;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 14:08
 * @Description:
 * @Other:
 */
public class MyException extends RuntimeException{
    
    public MyException(){
    }
    
    public MyException(String message){
        super(message);
    }
    
}
