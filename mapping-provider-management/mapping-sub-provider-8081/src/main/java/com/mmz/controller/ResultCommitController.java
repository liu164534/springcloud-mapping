package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.ResultCommit;
import com.mmz.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: provider-测绘成果
 * @author: Liu Xinpeng
 * @create: 2020-06-03 11:38
 **/
@RestController
public class ResultCommitController extends CommonController<ResultCommit> {
    @Override
    public BaseService<ResultCommit> getBaseService() {
        return resultCommitService;
    }
    @Autowired
    private ResultCommitService resultCommitService;

    /**
    * @Description: 根据条件查询测绘成果
    * @Param: [resultCommit]
    * @return: java.util.List<com.mmz.model.ResultCommit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    @PostMapping("getResultCommitName")
    public List<ResultCommit> getResultCommitName(@RequestBody ResultCommit resultCommit) {
        List<ResultCommit> resultCommits = resultCommitService.getResultCommitName(resultCommit);
        return resultCommits;
    }
}