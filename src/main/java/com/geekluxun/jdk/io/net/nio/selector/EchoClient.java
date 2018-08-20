package com.geekluxun.jdk.io.net.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-20 15:49
 * @Description:
 * @Other:
 */
public class EchoClient {
    private static SocketChannel client;
    private static EchoClient instance;
    private static ByteBuffer sndBuffer;
    private static ByteBuffer recvBuffer;
    
    public static EchoClient start(){
        if (instance == null){
            instance = new EchoClient();
        }
        
        return instance;
    }
    
    private EchoClient(){
        try {
            client = SocketChannel.open(new InetSocketAddress("localhost", 8041));
            sndBuffer = ByteBuffer.allocate(256);
            recvBuffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String sendMsg(String msg){
        sndBuffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            client.write(sndBuffer);
            client.read(recvBuffer);
            response = new String(recvBuffer.array());
            System.out.println("收到服务器数据:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public static void stop() throws IOException{
        client.close();
        recvBuffer = null;
        sndBuffer = null;
    }
    
}
