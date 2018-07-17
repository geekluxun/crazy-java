package com.geekluxun.apache.commons.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
            InputStream input = file.getInputStream();
            byte[] buf = new byte[4096];
            input.read(buf, 0, 4096);
            String str = new String(buf);
            System.out.println("文件内容:" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
