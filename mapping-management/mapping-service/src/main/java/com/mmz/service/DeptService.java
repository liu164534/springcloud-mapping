package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.DeptMapper;
import com.mmz.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Description: 部门管理
*@Author: Thanks
*@date: 2020/6/3
*/
@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;
    
    /**
    *@Description: 查询所有部门
    *@Param: []
    *@return: java.util.List<com.mmz.model.Dept>
    *@Author: Thanks
    *@date: 2020/6/3
    */
    public List<Dept> selectAllDept(){
        //获取到所有部门信息
        List<Dept> deptlist = deptMapper.selectAll();
        //判断是否查询到数据
        System.out.println(deptlist);
        if(null != deptlist && 0 < deptlist.size()){
            return deptlist;
        }else{
            //如果没有数据返回空
            return null;

        }
    }
    /**
     *@Description: 新增部门
     *@Param: [dept]
     *@return: boolean
     *@Author: Thanks
     *@date: 2020/6/3
     */
    public boolean insertDept(Dept dept){
        //添加部门
        int insert = deptMapper.insert(dept);
        //判断是否添加成功
        if (insert>0){
            //如果返回成功返回true
            return true;
        }else {
            //如果添加失败返回false
            return false;
        }
    }
    /**
     *@Description: 根据id删除部门
     *@Param: [dept]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    public Integer deleteDeptId(Dept dept){
        //删除部门
        int i = deptMapper.delete(dept);
        //判断是否删除成功
        if (i>0){
            return i;
        }else {
            return null;
        }
    }
    /**
     *@Description: 批量删除部门
     *@Param: [depts]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    public Integer deleteDepts(List<Object> depts){
        //先判断传入的数组是否为空
        if (depts.size()==0){
            //如果为空直接返回null
            return null;
        }else {
            try {
                //不为空则开始批量删除
                Integer integer = super.delete(depts);
                if (integer!=0){
                    return integer;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     *@Description: 修改部门信息
     *@Param: [dept]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    public Integer updateDept(Dept dept){
        //先判断传入参数是否为空
        if (dept==null){
            //如果为空直接返回null
            return null;
        }else {
            try {
                //如果不为空则开始修改部门信息
                Integer integer = super.update(dept);
                if (integer!=0){
                    return integer;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
