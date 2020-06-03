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
}