package com.mmz.controller;

import com.mmz.annotation.LoginLogAnnotation;
import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.User;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 用户管理
 * @author: ly
 * @create: 2020-05-28 14:16
 **/
@RestController
@Api(value = "用户管理", tags = "对用户进行接口")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
     * @Description: 查询所有用户
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: ly
     * @Date: 2020/5/28
     */
    //@LoginLogAnnotation(operationName = "管理员",operationType = "查询")   查询操作不需要记录
    @GetMapping("getAllUserInfo")
    public ResultData getAllUserInfo() {
        System.out.println("consumer-Controller");
        List<User> allUserInfo = iUserService.getAllUserInfo();
        if (!" ".equals(allUserInfo) && null != allUserInfo) {
            return super.selectSuccess(iUserService.getAllUserInfo());
        } else {
            return super.selectFailed();
        }

    }

    /**
     * @Description: 添加用户
     * @Param: [user]
     * @return: com.mmz.base.ResultData
     * @Author: ly
     * @Date: 2020/5/31
     */

    @LoginLogAnnotation(operationName = "苗管理员", operationType = "添加")
    @PostMapping("insertUser")
    public ResultData insertUser(@RequestBody User user) {

        System.out.println("consumer-Controller");
        user.setCreateTime("2020-06-01");
        Boolean aBoolean = iUserService.insertUser(user);
        if (aBoolean) {
            return super.insertSuccess();
        } else {
            return super.insertFailed();
        }
    }

    /**
     * @Description: 修改用户信息
     * @Param: [user]
     * @return: com.mmz.base.ResultData
     * @Author: ly
     * @Date: 2020/6/1
     */

    @LoginLogAnnotation(operationName = "苗管理员", operationType = "修改")
    @PostMapping("updateUser")
    public ResultData updateUserInfoById(@RequestBody User user) {

        System.out.println("consumer-Controller-----"+user);
        Boolean aBoolean = iUserService.insertUser(user);
        if (aBoolean) {
            return super.selectSuccess();
        } else {
            return super.updateFailed();
        }
    }
}
