package com.mmz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @program: springcloud-mapping
 * @description: 角色菜单
 * @author: Mr.Miao
 * @create: 2020-06-03 23:36
 **/
@Table(name = "t_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu {
    /**
     * 权限id
     */
    @Column(name = "ROLE_ID")
    private Long roleId;

    /**
     * 菜单id
     */
    @Column(name = "MENU_ID")
    private Long menuId;
}
