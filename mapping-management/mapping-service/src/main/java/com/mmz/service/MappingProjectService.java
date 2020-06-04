package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.MappingProjectMapper;
import com.mmz.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: 测绘项目service
 * @author: Liu Xinpeng
 * @create: 2020-06-02 23:20
 **/
@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    /**
    * @Description: 获取对应测绘项目的名称
    * @Param: [mappingProject]
    * @return: com.mmz.model.MappingProject
    * @Author: Liu Xinpeng
    * @Date: 2020/6/2
    */
    public List<MappingProject> getMappingProjectName(MappingProject mappingProject) {
        List<MappingProject> mappingProjects = mappingProjectMapper.getMappingProjectName(mappingProject);
        if (mappingProjects.size() > 0 && null != mappingProjects) {
            return mappingProjects;
        }
        return null;
    }
    /**
    *@Description: 新增项目
    *@Param: [mappingProject]
    *@return: java.lang.Boolean
    *@Author: Thanks
    *@date: 2020/6/4
    */
    public Boolean insertMappingProject(MappingProject mappingProject){
        //新增的项目默认的进行状态 审核状态 项目成果
        mappingProject.setStatus(2);
        mappingProject.setAuditStatus(1);
        mappingProject.setResultsStatus(3);
        int insert = mappingProjectMapper.insert(mappingProject);
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     *@Description: 修改项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    public Integer updateMappingProject(MappingProject mappingProject){
        //先判断传入参数是否为空
        if (mappingProject==null){
            //如果为空直接返回null
            return null;
        }else {
            try {
                //如果不为空则开始修改部门信息
                Integer integer = super.update(mappingProject);
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
     *@Description: 删除项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    public Integer deleteMappingProject(MappingProject mappingProject){
        int delete = mappingProjectMapper.delete(mappingProject);
        if (delete>0){
            return delete;
        }else {
            return null;
        }
    }
}