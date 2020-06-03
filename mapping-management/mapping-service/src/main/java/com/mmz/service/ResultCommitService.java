package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.ResultCommitMapper;
import com.mmz.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: 测绘成果
 * @author: Liu Xinpeng
 * @create: 2020-06-03 11:39
 **/
@Service
public class ResultCommitService extends BaseService<ResultCommit> {
    @Autowired
    private ResultCommitMapper resultCommitMapper;

    /**
    * @Description: 根据条件查询测绘成果
    * @Param: [resultCommit]
    * @return: java.util.List<com.mmz.model.ResultCommit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    public List<ResultCommit> getResultCommitName(ResultCommit resultCommit) {
        List<ResultCommit> resultCommits = resultCommitMapper.getResultCommitName(resultCommit);
        if (resultCommits.size() > 0 && null != resultCommits) {
            return resultCommits;
        }
        return null;
    }
}