package com.mmz.controller;

import com.mmz.model.Role;
import com.mmz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("selectAllRole")
    public List<Role> selectAllRole(){
        return roleService.selectAllRole();

    }
}
