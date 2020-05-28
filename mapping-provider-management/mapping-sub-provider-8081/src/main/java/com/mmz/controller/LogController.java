package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.base.ResultData;
import com.mmz.model.LoginLog;
import com.mmz.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: spring-cloud-mapping
 * @description: provider日志controller
 * @author: Liu Xinpeng
 * @create: 2020-05-28 10:06
 **/
@RestController
public class LogController extends CommonController<LoginLog> {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseService<LoginLog> getBaseService(){
        return loginLogService;
    }

    
    /**
    * @Description: 添加登陆日志
    * @Param: [loginLog]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    @PostMapping("/addLoginLog")
    public ResultData addLoginLog(@RequestBody Map map) {
        return super.add(map);
    }
}