package com.mmz.mapper;

import com.mmz.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description:
 *     测绘项目
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:28
 **/
public interface MappingProjectMapper extends Mapper<MappingProject> {

    
    /**
    * @Description: 根据条件获取对应测绘项目名称
    * @Param: [mappingProject]
    * @return: java.util.List<com.mmz.model.MappingProject> 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/2
    */
    List<MappingProject> getMappingProjectName(MappingProject mappingProject);
}