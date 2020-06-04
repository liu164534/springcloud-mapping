package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Dept;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
*@Description: 部门管理
*@Author: Thanks
*@date: 2020/6/3
*/
@RestController
@Api(value = "部门信息",tags = "部门管理")
public class DeptController extends BaseController{

    @Autowired
    private IUserService iUserService;
    
    /**
    *@Description: 查询所有部门
    *@Param: []
    *@return: com.mmz.base.ResultData
    *@Author: Thanks
    *@date: 2020/6/3
    */
    @GetMapping("/selectAllDept")
    public ResultData selectAllDept(){
        //获取所有部门信息
       List<Dept> deptlist = iUserService.selectAllDept();
        //判断是否获取到数据
        if(!"".equals(deptlist) && null != deptlist){
            //有数据则返回
            return super.selectSuccess(deptlist);
        }
        //没有数据返回失败
        return super.selectFailed();
    }
    /**
     *@Description: 新增部门
     *@Param: [dept]
     *@return: com.mmz.base.ResultData
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/insertDept")
    public ResultData insertDept(@RequestBody Dept dept){
        //判断返回值类型
        Boolean aBoolean =iUserService.insertDept(dept);
        if (aBoolean) {
            // 返回成功
            return super.insertSuccess();
        }
        // 返回失败
        return super.insertFailed();
    }
    /**
     *@Description: 根据id删除部门
     *@Param: [dept]
     *@return: com.mmz.base.ResultData
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/deleteDeptId")
    public ResultData deleteDept(@RequestBody Dept dept){
        //部门删除
        Integer integer = iUserService.deleteDeptId(dept);
        if(integer>0){
            // 返回成功
            return super.deleteSuccess();
        }else {
            // 返回失败
            return super.deleteFailed();
        }
    }
    /**
     *@Description: 批量删除部门
     *@Param: [depts]
     *@return: com.mmz.base.ResultData
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/deleteDepts")
    public ResultData deleteDepts(@RequestBody List<Object> depts){
        //批量删除
        Integer integer = iUserService.deleteDepts(depts);
        if(integer>0){
            // 返回成功
            return super.deleteSuccess();
        }else {
            // 返回失败
            return super.deleteFailed();
        }
    }
    /**
     *@Description: 修改部门信息
     *@Param: [dept]
     *@return: com.mmz.base.ResultData
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept){
        //修改部门信息
        Integer integer = iUserService.updateDept(dept);
        if(integer>0){
            // 返回成功
            return super.updateSuccess();
        }else {
            // 返回失败
            return super.updateFailed();
        }
    }

}
