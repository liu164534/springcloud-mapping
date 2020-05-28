package com.mmz.controller;

import com.mmz.annotation.LoginLogAnnotation;
import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.User;
import com.mmz.service.IUserService;
import com.mmz.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-mapping
 * @description: consumer的登陆controller
 * @author: Liu Xinpeng
 * @create: 2020-05-24 18:28
 **/
@RestController
// 标识这个类是swagger的资源 value、tags都是说明的意思
@Api(value = "登陆信息" ,tags = "用户登陆接口")
public class LoginController extends BaseController {

    @Autowired
    private IUserService IUserService;


    @PostMapping("/doLogin")
    @ApiOperation(value = "登陆功能" ,notes = "用户执行登陆的功能")
    @LoginLogAnnotation(operationType = "登陆操作",operationName = "管理员登陆")
    public ResultData doLogin(@RequestBody User user) {
        TokenVo tokenVo = IUserService.doLogin(user);
        // 通过往redis存储token值得结果来验证用户是否登陆成功
        if (tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }

}