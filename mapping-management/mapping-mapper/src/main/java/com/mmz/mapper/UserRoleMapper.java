package com.mmz.mapper;

import com.mmz.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

/**
* @Description: 用户权限mapper
* @Param: 
* @return: 
* @Author: Mr.miao
* @Date: 2020/6/2
*/
public interface UserRoleMapper extends Mapper<UserRole> {
    /**
    * @Description: 根据用户id删除role数据
    * @Param: []
    * @return: int
    * @Author: Mr.miao
    * @Date: 2020/6/3
    */
    int deleteUserRoleByUserId(Long id);
}
