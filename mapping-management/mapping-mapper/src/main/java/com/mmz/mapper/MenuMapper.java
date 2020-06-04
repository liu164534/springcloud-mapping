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

    Integer insertMenu(Menu menu);
}
