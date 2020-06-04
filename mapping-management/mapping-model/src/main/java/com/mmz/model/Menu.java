package com.mmz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * @program: springcloud-mapping
 * @description: 菜单类
 * @author: Mr.Miao
 * @create: 2020-06-04 09:54
 **/
@Table(name = "t_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    /**
     * 菜单/按钮ID
     */
    private Long menuId;
    /**
     * 上级菜单ID
     */
    private Long parentId;
    /**
     * 上级菜单ID数组
     */
    private List<Long> parentIdList;
    /**
     * 菜单/按钮名称
     */
    private String menuName;
    /**
     * 对应路由path
     */
    private String  path;
    /**
     * 对应路由组件component
     */
    private String component;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 类型 0菜单 1按钮
     */
    private String type;
    /**
     * 排序
     */
    private Double orderNum;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Max(value = 100, message = "时间最长不能超过100")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @Max(value = 100, message = "时间最长不能超过100")
    private String modifyTime;

}
