package com.mmz.mapper;

import com.mmz.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
*@Description: 部门管理
*@Author: Thanks
*@date: 2020/6/3
*/
public interface DeptMapper extends Mapper<Dept> {
    List<Dept> selectDept();
}
