package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.MappingProject;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: consumer-测绘项目
 * @author: Liu Xinpeng
 * @create: 2020-06-02 23:09
 **/
@RestController
@Api(value = "测绘项目",tags = "测绘项目接口")
public class MappingProjectController extends BaseController {
    
    @Autowired
    private IUserService iUserService;
    
    /**
    * @Description: 根据条件搜索测绘项目的名称
    * @Param: []
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/2
    */
    @PostMapping("getMappingProjectName")
    public ResultData getMappingProjectName(@RequestBody MappingProject mappingProject) {
        List<MappingProject> mappingProjectNames = iUserService.getMappingProjectName(mappingProject);
        if (null != mappingProject && mappingProjectNames.size() > 0) {
            return super.selectSuccess(mappingProjectNames);
        }
        return super.selectFailed();
    }
    
}