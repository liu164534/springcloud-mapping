package com.mmz.controller;

import com.mmz.base.ResultData;
import com.mmz.model.Role;
import com.mmz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 角色权限管理
 * @author: Mr.Miao
 * @create: 2020-06-03 23:43
 **/
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * @Description: 查看角色
     * @Param: []
     * @return: java.util.List<com.mmz.model.Role>
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @GetMapping("selectAllRole")
    public List<Role> selectAllRole() {
        return roleService.selectAllRole();

    }

    /**
     * @Description: 添加角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("insertRole")
    public Boolean insertRole(@RequestBody Role role) {
        return roleService.insertRole(role);

    }

    /**
     * @Description: 修改角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("updateRole")
    public Boolean updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    /**
     * @Description: 删除角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("deleteRole")
    public Boolean deleteRole(@RequestBody Role role) {
        return roleService.deleteRole(role);
    }
}
