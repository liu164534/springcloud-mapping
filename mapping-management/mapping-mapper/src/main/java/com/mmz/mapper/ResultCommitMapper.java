package com.mmz.mapper;

import com.mmz.model.ResultCommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 测绘成果
 */
public interface ResultCommitMapper extends Mapper<ResultCommit> {

    /**
    * @Description: 根据条件查询测绘成果
    * @Param: [resultCommit]
    * @return: java.util.List<com.mmz.model.ResultCommit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    List<ResultCommit> getResultCommitName(ResultCommit resultCommit);
}