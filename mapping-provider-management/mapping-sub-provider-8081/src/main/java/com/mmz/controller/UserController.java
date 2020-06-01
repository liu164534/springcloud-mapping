package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.ResultData;
import com.mmz.mapper.UserInfoMapper;
import com.mmz.model.User;
import com.mmz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 用户管理
 * @author: Mr.Miao
 * @create: 2020-05-28 17:02
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
    * @Description: 获取用户信息
    * @Param: []
    * @return: java.util.List<com.mmz.model.User>
    * @Author: Mr.miao
    * @Date: 2020/5/28
    */
    @GetMapping("getAllUserInfo")
    public List<User> getAllUserInfo() {
        System.out.println("provider-Contorller");
        List<User> userInfo = userService.getAllUserInfo();
        if (!" ".equals(userInfo) && null != userInfo) {
            return userInfo;
        } else {
            return null;
        }
    }
    /**
    * @Description: 添加用户
    * @Param: [user]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/1
    */
    @PostMapping("insertUser")
    public Boolean insertUser(@RequestBody User user){
        System.out.println("provider-Contorller-----"+user);
        user.setCreateTime("2020-06-01");
        return userService.insertUserInfo(user);

    }
    /**
    * @Description: 修改用户信息
    * @Param: [user]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/1
    */
    @PostMapping("updateUser")
    public Boolean updateUserInfoById(@RequestBody User user){
        System.out.println("provider-Contorller----"+user);

        user.setCreateTime("2020-06-01");
        return userService.updateUserInfoById(user);

    }
}
