package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.UserInfoMapper;
import com.mmz.mapper.UserRoleMapper;
import com.mmz.model.User;
import com.mmz.model.UserRole;
import com.mmz.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
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
    @Autowired
    private UserRoleMapper userRoleMapper;

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
    @Transactional
    public Boolean insertUserInfo(User user) {
        System.out.println("management-Service");
        userInfoMapper.insertUseGeneratedKeys(user);
        if (user.getId() == null) {
            return false;
        } else {
            int i = userRoleMapper.insert(new UserRole(user.getId().toString(),user.getType()));
            if (i < 1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
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
    public Boolean updateUserInfoById(User user) {
        System.out.println("management-Service----" + user);
        Integer i = userInfoMapper.updateUserInfo(user);
        if (i < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @Description: 删除用户信息
     * @Param: [user]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/3
     */

    @Transactional
    public Boolean deleteUserById(User user) {
        System.out.println("management-Service----"+user.getId());
        Integer i = userInfoMapper.deleteByPrimaryKey(user.getId());
        if (i < 1) {
            return false;
        } else {
            int delete = userRoleMapper.deleteUserRoleByUserId(user.getId());
            if (delete<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
            return true;
        }
    }
}
