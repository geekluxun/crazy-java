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
 * 多路复用io
 * @Other:
 */
public class EchoServer {
    
    public static void listen(){
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress("localhost", 8041));
            // 设置这个通道为非阻塞模式 
            // 在阻塞模式中，每一个 I/O 操作完成之前都会阻塞在其通道上调用的其他 I/O 操作
            serverSocket.configureBlocking(false);
            // 把这个通道注册到选择器中（此通道对accept感兴趣） 一个通道可以关联多个选择键
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer recvBuffer = ByteBuffer.allocate(256);
            ByteBuffer sndBuffer = ByteBuffer.allocate(256);
            
            
            while (true){
                // 阻塞 直到某个通道准备就绪
                selector.select();
                // 所有通道已选择键集合（至少有一个准备就绪）
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
                    // 移除此选择键从已选择键集合中（防止重复处理） 
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private static void register(Selector selector, ServerSocketChannel socketChannel) throws Exception{
        // 接收连接的客户端通道
        SocketChannel client = socketChannel.accept();
        client.configureBlocking(false);
        // 把此通道注册到选择上（对读感兴趣）
        client.register(selector, SelectionKey.OP_READ);
    }
    
    private static void handle(ByteBuffer readBuffer, ByteBuffer sendBuffer, SelectionKey key) throws Exception{
        // 根据selectkey得到此通道
        SocketChannel client = (SocketChannel) key.channel();
        // 从此通道读取数据
        client.read(readBuffer);
        // 必须清空 否则write时候客户端收到的将是空
        readBuffer.clear();
        System.out.println("收到客户端数据:" + new String(readBuffer.array()));
        client.write(readBuffer);
    }
}
