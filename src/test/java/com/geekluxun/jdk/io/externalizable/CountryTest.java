package com.geekluxun.jdk.io.externalizable;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @Author: luxun
 * @Create: 2018-11-03 15:36
 * @Description:
 * @Other:
 */
public class CountryTest {

    private final static String OUTPUT_FILE = "externalizable.txt";

    @Test
    public void writeExternal() throws IOException, ClassNotFoundException {
        Country c1 = new Country();
        c1.setCapital("beijing");
        c1.setCode(1111);
        c1.setName("china");

        FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        c1.writeExternal(outputStream);
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Country c2 = new Country();
        c2.readExternal(inputStream);
        inputStream.close();

        Assert.isTrue(c1.getCapital().equals(c2.getCapital()));
        Assert.isTrue(c1.getCode() == c2.getCode());
        Assert.isTrue(c1.getName().equals(c2.getName()));
    }

    @Test
    public void readExternal() {
    }
}