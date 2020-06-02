package com.mmz.controller;

import com.mmz.model.User;
import com.mmz.redis.RedisService;
import com.mmz.service.LoginService;
import com.mmz.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.LinkedHashMap;

/**
 * @program: spring-cloud-mapping
 * @description: privoder的登陆controller
 * @author: Liu Xinpeng
 * @create: 2020-05-24 17:36
 **/
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisService redisService;
    
    /**
    * @Description: 执行登陆操作
    * @Param: [user]
    * @return: com.mmz.vo.TokenVo 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody User user) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Enumeration<String> headerNames =
                attributes.getRequest().getHeaderNames();
        LinkedHashMap map = new LinkedHashMap();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = attributes.getRequest().getHeader(key);
            map.put(key, value);
        }
        System.out.println(map);
        return loginService.doLogin(user, redisService);
    }

}