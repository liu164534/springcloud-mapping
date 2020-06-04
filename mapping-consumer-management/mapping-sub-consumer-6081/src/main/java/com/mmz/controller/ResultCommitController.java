package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.ResultCommit;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: consumer-测绘成果
 * @author: Liu Xinpeng
 * @create: 2020-06-03 11:34
 **/
@RestController
@Api(value = "测绘成果",tags = "测绘成果接口")
public class ResultCommitController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
    * @Description: 根据条件查询测绘成果
    * @Param: [resultCommit]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    @PostMapping("getResultCommitName")
    public ResultData getResultCommitName(@RequestBody ResultCommit resultCommit) {
        List<ResultCommit> resultCommits = iUserService.getResultCommitName(resultCommit);
        if (resultCommits.size() > 0 && null != resultCommits) {
            return super.selectSuccess(resultCommits);
        }
        return super.selectFailed();
    }
}