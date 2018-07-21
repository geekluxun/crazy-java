package com.geekluxun.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 9:34
 * @Description:
 * @Other:
 */
public class HexDemo {
    public static void main(String[] argc){
        HexDemo demo = new HexDemo();
        demo.demo1();
    }

    /**
     * 转换成16进制
     */
    private void demo1(){
        char[] src = new char[]{'a', '0', '2', 'f'};
        byte[] hex;
        try {
            // 0xa0 , 0x2f
            hex  = Hex.decodeHex(src);
            hex = Hex.decodeHex("a02f");
            System.out.println();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        ByteBuffer data = ByteBuffer.allocate(10);
        data.put(new byte[]{-116, -30, 50});
        char[] data2 = Hex.encodeHex(data);
        // 16进制大写
        data2 = Hex.encodeHex(data, false);
        String dataStr1 = new String(data2);
        // 16进制字符串(默认小写)
        String dataStr2 =Hex.encodeHexString(data);
        System.out.println();
    }
}
