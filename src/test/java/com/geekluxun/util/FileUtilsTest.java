package com.geekluxun.util;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: luxun
 * @Create: 2019-07-09 10:39
 * @Description:
 * @Other:
 */
public class FileUtilsTest {

    @Test
    public void getFileNames() throws IOException {
        List<String> fileNameList = FileUtils.getFileNames("C:\\Users\\luxun\\Downloads\\baidu\\技术书籍");
        File file = new File("C:\\Users\\luxun\\Downloads\\baidu\\1.txt");
        FileOutputStream stream = new FileOutputStream(file);
        fileNameList.stream().forEach((e) -> {
            try {
                stream.write(e.getBytes());
                stream.write("\r\n".getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        stream.close();
    }
}