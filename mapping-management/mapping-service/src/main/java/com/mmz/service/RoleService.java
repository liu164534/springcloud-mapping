package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.RoleMapper;
import com.mmz.mapper.RoleMenuMapper;
import com.mmz.model.Role;
import com.mmz.model.RoleMenu;
import com.mmz.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    @Autowired
    RoleMenuMapper roleMenuMapper;

    /**
     * @Description: 获取所有角色信息
     * @Param: []
     * @return: java.util.List<com.mmz.model.Role>
     * @Author: Mr.miao
     * @Date: 2020/6/3
     */
    public List<Role> selectAllRole() {
        List<Role> roleList = roleMapper.selectAll();
        if (roleList == null || roleList.size() < 1) {
            return null;
        }
        return roleList;
    }

    @Transactional
    public Boolean insertRole(Role role) {
        roleMapper.insertUseGeneratedKeys(role);

        if (role.getRoleId() == null) {
            return false;
        } else {
            //循环遍历role中menuIDlist添加
            for (Long menuId : role.getMenuIdList()) {
                int i = roleMenuMapper.insert(new RoleMenu(role.getRoleId(), menuId));
                if (i < 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        }
    }

    @Transactional
    public Boolean updateRole(Role role) {
        int updateRole = roleMapper.updateRoleByRoleId(role);
        if (updateRole > 0) {
            //删除原有的菜单
            Integer deleteRoleMenu = roleMenuMapper.deleteByRoleId(role.getRoleId());
            if (deleteRoleMenu > 0) {
                for (Long menuId : role.getMenuIdList()) {
                    //添加修改后的菜单
                    int insertRoleMenu = roleMenuMapper.insert(new RoleMenu(role.getRoleId(), menuId));
                    if (insertRoleMenu < 1) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    @Transactional
    public Boolean deleteRole(Role role){
        int i = roleMapper.deleteRoleByRoleId(role.getRoleId());
        if (i < 1) {
            System.out.println(111);
            return false;
        } else {
            int delete = roleMenuMapper.deleteByRoleId(role.getRoleId());
            if (delete<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                System.out.println(222);
                return false;
            }
            System.out.println(333);
            return true;
        }
    }
}
