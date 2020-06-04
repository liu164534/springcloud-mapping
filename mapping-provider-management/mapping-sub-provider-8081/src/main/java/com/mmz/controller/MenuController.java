package com.mmz.controller;

import com.mmz.model.Menu;
import com.mmz.service.MenuService;
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
 * @create: 2020-06-04 15:12
 **/
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * @Description: 获取所有菜单
     * @Param: []
     * @return: java.util.List<com.mmz.model.Menu>
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @GetMapping("getAllMenu")
    public List<Menu> getAllMenu() {

        return menuService.getAllMenu();
    }

    /**
     * @Description: 添加菜单
     * @Param: [menu]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("insertMenu")
    public Boolean insertMenu(@RequestBody Menu menu) {
        return menuService.insertMenu(menu);
    }

    @PostMapping("updateMenu")
    public Boolean updateMenu(@RequestBody Menu menu) {
        return menuService.updateMenu(menu);
    }
    @PostMapping("deleteMenu")
    public Boolean deleteMenu(@RequestBody Menu menu){
        System.out.println(menu);
        return  menuService.deleteMenu(menu);
    }
}
