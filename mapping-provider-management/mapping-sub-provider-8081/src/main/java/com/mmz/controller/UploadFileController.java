package com.mmz.controller;

import com.mmz.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: spring-cloud-mapping
 * @description: provicer-文件上传
 * @author: Liu Xinpeng
 * @create: 2020-06-03 19:59
 **/
@RestController
public class UploadFileController {
    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean uploadFile(@RequestBody MultipartFile multipartFile) {
        if(multipartFile == null ){
      System.out.println("空的呀");
        }
            return uploadService.uploadFile(multipartFile);
    }
}