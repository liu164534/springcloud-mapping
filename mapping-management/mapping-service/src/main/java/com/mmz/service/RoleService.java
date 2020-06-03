package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.RoleMapper;
import com.mmz.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 角色权限管理
 * @author: Mr.Miao
 * @create: 2020-06-03 23:43
 **/
@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    RoleMapper roleMapper;
    /**
    * @Description: 获取所有角色信息
    * @Param: []
    * @return: java.util.List<com.mmz.model.Role>
    * @Author: Mr.miao
    * @Date: 2020/6/3
    */
    public List<Role> selectAllRole(){
        List<Role> roleList = roleMapper.selectAll();
        if (roleList == null || roleList.size() < 1) {
            return null;
        }
        return roleList;
    }
}
