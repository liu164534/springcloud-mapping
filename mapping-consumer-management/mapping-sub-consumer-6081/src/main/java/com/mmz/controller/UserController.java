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
 * @author: Mr.miao
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
     * @Author: Mr.miao
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
     * @Author: Mr.miao
     * @Date: 2020/5/31
     */

    @PostMapping("insertUser")
    public ResultData insertUser(@RequestBody User user) {

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
     * @Author: Mr.miao
     * @Date: 2020/6/1
     */

    @PostMapping("updateUser")
    public ResultData updateUserInfoById(@RequestBody User user) {

        Boolean aBoolean = iUserService.updateUserInfoById(user);
        if (aBoolean) {
            return super.updateSuccess();
        } else {
            return super.updateFailed();
        }
    }

    /**
     * @Description: 删除用户信息
     * @Param: [user]
     * @return: com.mmz.base.ResultData
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("deleteUserById")
    public ResultData deleteUserById(@RequestBody User user) {
        Boolean aBoolean = iUserService.deleteUserById(user);
        if (aBoolean) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }

    }
}
