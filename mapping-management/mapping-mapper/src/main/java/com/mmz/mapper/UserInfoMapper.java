package com.mmz.mapper;

import com.mmz.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigInteger;


/**
 * @program: springcloud-mapping
 * @description: 用户管理
 * @author: ly
 * @create: 2020-05-28 13:59
 **/

public interface UserInfoMapper extends Mapper<User> {
    /**
    * @Description: 添加用户并返回主键
    * @Param: [user]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/2
    */
    Long insertUseGeneratedKeys(User user);
    /**
    * @Description: 修改用户信息
    * @Param: [user]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer updateUserInfo(User user);

}
