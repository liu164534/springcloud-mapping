package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Menu;
import com.mmz.model.Role;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 菜单管理
 * @author: Mr.Miao
 * @create: 2020-06-04 15:19
 **/
@RestController
@Api(value = "菜单管理", tags = "对菜单进行管理")
public class MenuController extends BaseController{
    @Autowired
    IUserService service;

    @GetMapping("getAllMenu")
    public ResultData getAllMenu(){
        List<Menu> menuList = service.getAllMenu();
        if (!" ".equals(menuList) && null != menuList) {
            return super.selectSuccess(menuList);
        } else {
            return super.selectFailed();
        }
    }
    @PostMapping("insertMenu")
    public ResultData insertMenu(@RequestBody Menu menu){
        Boolean aBoolean = service.insertMenu(menu);
        if (aBoolean) {
            return super.insertSuccess();
        } else {
            return super.insertFailed();
        }
    }
}
