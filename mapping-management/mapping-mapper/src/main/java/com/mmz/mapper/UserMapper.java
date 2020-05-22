package com.mmz.mapper;

import com.mmz.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:24
 **/

/**
 * mybatis使用通用Mapper需要继承 tk.mybatis包中的Mapper<T>
 */
public interface UserMapper extends Mapper<User> {
}