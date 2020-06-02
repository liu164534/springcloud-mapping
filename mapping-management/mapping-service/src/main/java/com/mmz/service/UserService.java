package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.UserInfoMapper;
import com.mmz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 用户服务层
 * @author: ly
 * @create: 2020-05-24 22:22
 **/
@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @Description:获取用户信息
     * @Param: []
     * @return: boolean
     * @Author: Mr.miao
     * @Date: 2020/5/24
     */
    public List<User> getAllUserInfo() {
        System.out.println("management-Service");
        List<User> userList = userInfoMapper.selectAll();
        if (userList == null || userList.size() < 1) {
            return null;
        }
        return userList;
    }
    /**
    * @Description: 增加用户
    * @Param: [user]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/5/31
    */
    public Boolean insertUserInfo(User user){
        System.out.println("management-Service");
        Integer i=userInfoMapper.insert(user);
        if (i < 1) {
            return false;
        }else {
            return true;
        }
    }
    /**
    * @Description: 修改用户信息
    * @Param: [user]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/1
    */
    public Boolean updateUserInfoById(User user){
        System.out.println("management-Service----"+user);
        Integer i=userInfoMapper.updateByPrimaryKey(user);
        if (i < 1) {
            return false;
        }else {
            return true;
        }
    }
}
