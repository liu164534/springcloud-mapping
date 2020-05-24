package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.User;
import com.mmz.service.IMMZService;
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
    private IMMZService immzService;

    @PostMapping("/doLogin")
    @ApiOperation(value = "登陆功能" ,notes = "用户执行登陆的功能")
    public ResultData doLogin(@RequestBody User user) {
        TokenVo tokenVo = immzService.doLogin(user);
        // 通过往redis存储token值得结果来验证用户是否登陆成功
        if (tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }

}