package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.MappingUnit;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: consumer-测绘单位
 * @author: Liu Xinpeng
 * @create: 2020-06-03 09:32
 **/
@RestController
@Api(value = "测绘单位",tags = "测绘单位接口")
public class MappingUnitController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
    * @Description: 根据条件搜索测绘单位的名称
    * @Param: [mappingUnit]
    * @return: com.mmz.base.ResultData
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    @PostMapping("getMappingUnitName")
    public ResultData getMappingUnitName(@RequestBody MappingUnit mappingUnit) {
        List<MappingUnit> mappingUnitNames = iUserService.getMappingUnitName(mappingUnit);
        if (mappingUnitNames.size() > 0 && null != mappingUnitNames) {
            return super.selectSuccess(mappingUnitNames);
        }
        return super.selectFailed();
    }
}