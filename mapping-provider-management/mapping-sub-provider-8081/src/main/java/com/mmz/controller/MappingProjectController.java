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


}