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
     * Transactional 事务回滚
     */

    @Transactional(rollbackFor = Exception.class)
    public Boolean insertUserInfo(User user) {
        System.out.println("management-Service");

        try {
            //获取新增后的主键id
            userInfoMapper.insertUseGeneratedKeys(user);
            if (user.getId()==null) {
                return false;
            } else {
                //新增该用户的权限
                int i = userRoleMapper.insert(new UserRole(user.getId(), 3L));
                if(i<1){
                    //事务回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
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
        Integer i = null;
        try {
            i = super.update(user);
            if (i < 1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
