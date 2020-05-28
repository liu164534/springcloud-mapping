package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.UserInfoMapper;
import com.mmz.model.User;
import com.mmz.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 用户服务层
 * @author: Mr.Miao
 * @create: 2020-05-24 22:22
 **/
@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @Description:
     * @Param: []
     * @return: boolean
     * @Author: Mr.miao
     * @Date: 2020/5/24
     */
    public List<User> getAllUserInfo() {
        List<User> userList = userInfoMapper.selectAll();
        if (userList == null || userList.size() < 1) {
            return null;
        }
        return userList;
    }
}
