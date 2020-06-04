package com.mmz.service;

import com.mmz.properties.FtpProperties;
import com.mmz.utils.DateUtils;
import com.mmz.utils.FTPUtils;
import com.mmz.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: spring-cloud-mapping
 * @description: 文件上传service
 * @author: Liu Xinpeng
 * @create: 2020-06-03 19:45
 **/
@Service
public class UploadService {
    @Autowired
    private FtpProperties ftpProperties;

    /**
    * @Description: ftp文件上传
    * @Param: [multipartFile]
    * @return: java.lang.Boolean
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    public Boolean uploadFile(MultipartFile file) {
        // 1.获取文件原始的名称(目的是为了获取文件的后缀名)
        String oldFilename = file.getOriginalFilename();
    System.out.println(oldFilename);
        // 2.生成新的文件名(不带文件类型后缀)
        String newFileName = FileNameUtils.getFileName();
        // 3.获取最终的文件名(新生成的文件名拼接后缀)
        newFileName = newFileName + oldFilename.substring(oldFilename.lastIndexOf("."));
    System.out.println(newFileName);
        try{
            // 4.获取当前日期格式化后的字符串
            String filePath = DateUtils.getDate();
            return FTPUtils.uploadFile(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), filePath, ftpProperties.getBasePath(), newFileName, file.getInputStream());
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return false;
    }
}