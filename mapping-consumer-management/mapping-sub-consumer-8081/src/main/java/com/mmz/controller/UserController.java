package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.User;
import com.mmz.service.IMMZService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 用户管理
 * @author: Mr.Miao
 * @create: 2020-05-28 14:16
 **/
@RestController
@Api(value = "用户管理", tags = "对用户进行接口")
public class UserController extends BaseController {
    @Autowired
    IMMZService immzService;
    /**
    * @Description: 查询所有用户
    * @Param: []
    * @return: com.mmz.base.ResultData
    * @Author: Mr.miao
    * @Date: 2020/5/28
    */
    //@LoginLogAnnotation(operationName = "管理员",operationType = "查询")   查询操作不需要记录
    @GetMapping("getAllUserInfo")
    public ResultData getAllUserInfo()
    {
        List<User> allUserInfo = immzService.getAllUserInfo();
        if (!" ".equals(allUserInfo) && null != allUserInfo) {
            return super.selectSuccesss(immzService.getAllUserInfo());
        } else {
            return super.selectFailed();
        }

    }
}
