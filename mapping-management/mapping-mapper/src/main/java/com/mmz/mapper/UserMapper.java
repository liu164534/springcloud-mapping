package com.mmz.mapper;


import com.mmz.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * 继承Mapper类 ，就可以直接使用提供对该表的简单crud
 */
public interface UserMapper extends Mapper<User> {
}