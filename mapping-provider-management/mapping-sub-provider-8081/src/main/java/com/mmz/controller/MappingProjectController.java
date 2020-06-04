package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.MappingProject;
import com.mmz.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: provicer-测绘项目
 * @author: Liu Xinpeng
 * @create: 2020-06-02 23:24
 **/
@RestController
public class MappingProjectController extends CommonController{

    @Autowired
    private MappingProjectService mappingProjectService;

    @Override
    public BaseService getBaseService() {
        return mappingProjectService;
    }

    /**
    * @Description: 根据条件查询测绘项目的名称
    * @Param: [mappingProject]
    * @return: com.mmz.model.MappingProject
    * @Author: Liu Xinpeng
    * @Date: 2020/6/2
    */
    @PostMapping("/getMappingProjectName")
    public List<MappingProject> getMappingProjectName(@RequestBody MappingProject mappingProject) {
        List<MappingProject> mappingProjectNames = mappingProjectService.getMappingProjectName(mappingProject);
        return mappingProjectNames;
    }

    /**
     *@Description: 新增项目
     *@Param: [mappingProject]
     *@return: java.lang.Boolean
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/insertMappingProject")
    public Boolean insertMappingProject(@RequestBody MappingProject mappingProject){
        return mappingProjectService.insertMappingProject(mappingProject);
    }

    /**
     *@Description: 修改项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/updateMappingProject")
    public Integer updateMappingProject(@RequestBody MappingProject mappingProject){
        return mappingProjectService.updateMappingProject(mappingProject);
    }

    /**
     *@Description: 删除项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/deleteMappingProject")
    public Integer deleteMappingProject(@RequestBody MappingProject mappingProject){
        return mappingProjectService.deleteMappingProject(mappingProject);
    }
}