package com.mmz.controller;


import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.base.ResultData;
import com.mmz.model.Dept;
import com.mmz.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*@Description: 部门管理
*@Author: Thanks
*@date: 2020/6/3
*/
@RestController
public class DeptController extends CommonController<Dept> {

    @Autowired
    private DeptService deptService;
    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }
    /**
    *@Description: 查询所有部门
    *@Param: []
    *@return: com.mmz.base.ResultData
    *@Author: Thanks
    *@date: 2020/6/3
    */
    @GetMapping("/selectAllDept")
    public List<Dept> selectAllDept(){
        //获取所有部门信息
        List<Dept> deptlist = deptService.selectAllDept();
        //判断是否获取到数据
        if(!"".equals(deptlist) && null != deptlist){
            //有数据则返回
            return deptlist;
        }
        //没有数据返回失败
        return null;
    }
    /**
     *@Description: 新增部门
     *@Param: [dept]
     *@return: boolean
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/insertDept")
    public boolean insertDept(@RequestBody Dept dept){
        return deptService.insertDept(dept);
    }
    /**
     *@Description: 根据Id删除部门
     *@Param: [dept]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/deleteDeptId")
    public Integer deleteDeptId(@RequestBody Dept dept){
        return deptService.deleteDeptId(dept);
    }
    /**
     *@Description: 批量删除部门
     *@Param: [depts]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/deleteDepts")
    public Integer deleteDepts(@RequestBody List<Object> depts){
        return deptService.deleteDepts(depts);
    }
    /**
     *@Description: 修改部门信息
     *@Param: [dept]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/updateDept")
    public Integer updateDept(@RequestBody Dept dept){
        return deptService.updateDept(dept);
    }
}
