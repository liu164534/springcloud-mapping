package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Role;
import com.mmz.model.User;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 角色管理
 * @author: Mr.Miao
 * @create: 2020-06-03 23:40
 **/

@RestController
@Api(value = "角色管理", tags = "角色对应菜单管理")
public class RoleController extends BaseController {
    @Autowired
    IUserService service;

    @GetMapping("selectAllRole")
    public ResultData selectAllRole(){
        List<Role> roleList = service.selectAllRole();
        if (!" ".equals(roleList) && null != roleList) {
            return super.selectSuccess(roleList);
        } else {
            return super.selectFailed();
        }
    }
}
