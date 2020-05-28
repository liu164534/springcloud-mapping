package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.UserMapper;
import com.mmz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-mapping
 * @description: 用户服务层
 * @author: Mr.Miao
 * @create: 2020-05-24 22:22
 **/
@Service
public class UserService extends BaseService<User> {

    @Autowired
    UserMapper userMapper;
    /**
     * @Description:
     * @Param: []
     * @return: boolean
     * @Author: Mr.miao
     * @Date: 2020/5/24
     */
    public boolean getAllUserInfo() {
        return false;
    }
}
