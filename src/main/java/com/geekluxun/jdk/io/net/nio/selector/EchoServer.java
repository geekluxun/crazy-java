package com.geekluxun.jdk.io.net.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-20 15:50
 * @Description:
 * @Other:
 */
public class EchoServer {
    
    public static void listen(){
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress("localhost", 8041));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer recvBuffer = ByteBuffer.allocate(256);
            ByteBuffer sndBuffer = ByteBuffer.allocate(256);
            
            
            while (true){
                selector.select();
                Set<SelectionKey>  selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    // 处理accept
                    if (key.isAcceptable()){
                        System.out.println("accept!!!");
                        register(selector, serverSocket);                
                    } 
                    
                    // 接收数据
                    if (key.isReadable()){
                        System.out.println("read!!!");
                        handle(recvBuffer, sndBuffer, key);
                    }
                    // 此处一定要移除到这个元素！！！ 
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private static void register(Selector selector, ServerSocketChannel socketChannel) throws Exception{
        SocketChannel client = socketChannel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }
    
    private static void handle(ByteBuffer readBuffer, ByteBuffer sendBuffer, SelectionKey key) throws Exception{
        SocketChannel client = (SocketChannel) key.channel();
        client.read(readBuffer);
        // 必须清空 否则write时候客户端收到的将是空
        readBuffer.clear();
        System.out.println("收到客户端数据:" + new String(readBuffer.array()));
        client.write(readBuffer);
    }
}
