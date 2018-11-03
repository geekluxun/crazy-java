package com.geekluxun.jdk.io.file;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: luxun
 * @Create: 2018-11-03 15:55
 * @Description:
 * @Other:
 */
public class FileDemo {

    public static void main(String[] argc) {

    }


    public List<String> generateArrayListFromFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
            return result;
        }
    }
}
