package com.geekluxun.web;

import com.geekluxun.apache.commons.fileupload.FileUploadDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 13:16
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/upload")
public class UploadFileController {
    @Autowired
    FileUploadDemo fileUploadDemo;

    @GetMapping("/getuploadfile")
    public ModelAndView getUpLoadFilePage() {
        ModelAndView modelAndView = new ModelAndView("uploadfile");
        return modelAndView;
    }

    /**
     * 上传文件示例
     *
     * @param request
     */
    @GetMapping("/uploadfile")
    public void upLoadFile(HttpServletRequest request) {
        fileUploadDemo.demo2(request);
    }
}
