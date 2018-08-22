package com.geekluxun.java.net;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-15 10:31
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NetTest {

    @Test
    public void test1() {
        //byte[] ip = new byte[] { 116, 62, 63, 81 };
        byte[] ip = new byte[]{127, 0, 0, 1};


        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(InetAddress.getByAddress(ip), 2181));
            InetAddress address = InetAddress.getByName("localhost");
            address = InetAddress.getLocalHost();
            address = InetAddress.getLoopbackAddress();
            ip = address.getAddress();
            int port = socket.getLocalPort();
            System.out.println();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(true);
    }


    @Test
    public void test2() {
        byte[] ip = new byte[4];
        try {
            // 返回本地主机
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getAddress();
            // 字符串形式ip地址
            String hostAddress = address.getHostAddress();
            // 主机名
            String hostName = address.getHostName();
            System.out.println();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        Enumeration<NetworkInterface> nets = null;
        try {
            nets = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (NetworkInterface nif : Collections.list(nets)) {
            Enumeration<InetAddress> addrs = nif.getInetAddresses();
            while (addrs.hasMoreElements()) {
                System.out.println("地址:" + addrs.nextElement().getHostAddress());
            }
        }

        Assert.assertTrue(true);
    }

    @Test
    public void givenHostName_whenReturnsNetworkInterface_thenCorrect() {
        NetworkInterface nif = null;
        try {
            nif = NetworkInterface.getByInetAddress(InetAddress.getByName("localhost"));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(nif);
    }


    @Test
    public void givenInterface_whenReturnsInterfaceAddresses_thenCorrect() {

        NetworkInterface nif = null;
        try {
            // 网卡
            nif = NetworkInterface.getByName("lo");
        } catch (SocketException e) {
            e.printStackTrace();
        }
        List<InterfaceAddress> addressEnum = nif.getInterfaceAddresses();
        InterfaceAddress address = addressEnum.get(0);

        InetAddress localAddress = address.getAddress();
        InetAddress broadCastAddress = address.getBroadcast();

        assertEquals("127.0.0.1", localAddress.getHostAddress());
        assertEquals("127.255.255.255", broadCastAddress.getHostAddress());
        try {
            // 在用
            assertTrue(nif.isUp());
            // 不是子网卡
            assertFalse(nif.isVirtual());
            byte[] add = nif.getHardwareAddress();
            int mtu = nif.getMTU();
            // assertEquals(1500, mtu);
            System.out.println();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

}
