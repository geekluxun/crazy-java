package com.geekluxun.jdk.io.net.nio.selector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-20 16:38
 * @Description:
 * @Other:
 */
public class SelectorDemo {
    
    public static void main(String[] argc){
        SelectorDemo demo = new SelectorDemo();
        demo.test();
    }
    
    private void test(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new ServerTask());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        
        EchoClient client = EchoClient.start();
        System.out.println();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String response = client.sendMsg("hello!!!");
        System.out.println("server response:" + response);
    }
    
    private class ServerTask implements Runnable{

        @Override
        public void run() {
            EchoServer.listen();
        }
    }
}
