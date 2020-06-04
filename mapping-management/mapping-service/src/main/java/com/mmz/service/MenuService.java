package com.mmz.service;

import com.mmz.mapper.MenuMapper;
import com.mmz.model.Menu;
import com.mmz.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 菜单管理
 * @author: Mr.Miao
 * @create: 2020-06-04 15:13
 **/
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        List<Menu> menuList = menuMapper.selectAll();
        if (menuList == null || menuList.size() < 1) {
            return null;
        }
        return menuList;
    }
    /**
    * @Description: 添加角色
    * @Param: [menu]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    @Transactional
    public Boolean insertMenu(Menu menu){
        if("".equals(menu.getParentIdList())||menu.getParentIdList()==null){
            menu.setParentId(0L);
            int i = menuMapper.insertMenu(menu);
            if (i>0){
                return true;
            }
            return false;
        }else {
            for (Long parentId:menu.getParentIdList()){
                menu.setParentId(parentId);
                int i = menuMapper.insertMenu(menu);
                if (i < 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        }
    }
    /**
    * @Description: 修改菜单
    * @Param: [menu]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    public Boolean updateMenu(Menu menu){
        return false;
    }
    /**
    * @Description: 删除菜单
    * @Param: [menu]
    * @return: java.lang.Boolean
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    public Boolean deleteMenu(Menu menu){
        int deleteByPrimaryKey = menuMapper.deleteByPrimaryKey(menu.getMenuId());
        if (deleteByPrimaryKey>0){
            try {
                menuMapper.deleteMenuByParentId(menu.getMenuId());
                return true;
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }

        }return false;
    }
}
