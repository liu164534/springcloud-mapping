package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: spring-cloud-mapping
 * @description: 文件上传
 * @author: Liu Xinpeng
 * @create: 2020-06-03 19:24
 **/
@RestController
@Api(value = "文件上传",tags = "文件上传接口")
public class UploadController extends BaseController {

    @Autowired
    private IUserService iUserService;
    
    /**
    * @Description: 上传单个文件
    * @Param: [multipartFile]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PostMapping("/uploadFile")
    @ApiOperation(value = "文件上传",notes = "单文件上传接口")
    public ResultData uploadFile(@RequestBody MultipartFile multipartFile) {
        Boolean file = iUserService.uploadFile(multipartFile);
    System.out.println("consumer");
        if (file) {
            return super.insertSuccess("true");
        }
        return super.insertFailed("false");
    }

}