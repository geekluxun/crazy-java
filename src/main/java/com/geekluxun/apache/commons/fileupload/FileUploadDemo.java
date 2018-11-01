package com.geekluxun.apache.commons.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 17:47
 * @Description:
 * @Other:
 */
@Service
public class FileUploadDemo {
    public static void main(String[] argc) {

    }

    /**
     * 因为springmvc已经通过MultipartResolver解析了问题件，此处会获取不到file!!!
     *
     * @param request
     */
    public void demo1(HttpServletRequest request) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = request.getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            System.out.println();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    /**
     * springMVC方式 获取上传的文件
     *
     * @param request
     */
    public void demo2(HttpServletRequest request) {
        // 转型为MultipartHttpRequest：   
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：   
        MultipartFile file = multipartRequest.getFile("file1");
        // 获得文件名：   
        String filename = file.getOriginalFilename();
        // 获得输入流：   
        try {
            // 字节流转成字符流
//            BufferedReader buf = new BufferedReader(new InputStreamReader(file.getInputStream()));
//            System.out.println("读取的文件内容:");
//            String line;
//            while ((line = buf.readLine()) != null) {
//                System.out.println(line);
//            }
            // 直接把输入流转换成文件！！！
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
