package com.mmz.mapper;

import com.mmz.model.Role;
import tk.mybatis.mapper.common.Mapper;
/**
* @Description: 角色表
* @Param:
* @return:
* @Author: Mr.miao
* @Date: 2020/6/3
*/
public interface RoleMapper extends Mapper<Role> {
    /**
    * @Description: 添加角色并返回主键
    * @Param: [role]
    * @return: java.lang.Long
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer insertUseGeneratedKeys(Role role);
    /**
    * @Description: 修改信息
    * @Param: [role]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer updateRoleByRoleId(Role role);
    /**
    * @Description: 删除角色
    * @Param: [role]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer deleteRoleByRoleId(Long roleId);
}
