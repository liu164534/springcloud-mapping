package com.mmz.mapper;

import com.mmz.model.Menu;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: springcloud-mapping
 * @description:
 * @author: Mr.Miao
 * @create: 2020-06-04 15:13
 **/
public interface MenuMapper extends Mapper<Menu> {
/**
* @Description: 添加菜单
* @Param: [menu]
* @return: java.lang.Integer
* @Author: Mr.miao
* @Date: 2020/6/4
*/
    Integer insertMenu(Menu menu);
    /**
    * @Description: 删除菜单
    * @Param: [parentId]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer deleteMenuByParentId(Long parentId);
    /**
    * @Description: 根据菜单id删除菜单
    * @Param: [MenuId]
    * @return: java.lang.Integer
    * @Author: Mr.miao
    * @Date: 2020/6/4
    */
    Integer deleteMenuByMenuId(Long MenuId);
}
