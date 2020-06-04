package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.MappingUnit;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    
    /**
    * @Description: 首页注册测绘单位
    * @Param: [mappingUnit]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PutMapping("addMappingUnit")
    public ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit) {
        Integer integer = iUserService.addMappingUnit(mappingUnit);
        if (integer > 0) {
            return super.insertSuccess();
        }
        return super.insertFailed();
    }
    
    /**
    * @Description: 查询注册待审核的测绘单位
    * @Param: []
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @GetMapping("getAuditMappingUnit")
    public ResultData getAuditMappingUnit() {
        List<MappingUnit> auditMappingUnit = iUserService.getAuditMappingUnit();
        if (auditMappingUnit.size() > 0 && null != auditMappingUnit) {
            return super.selectSuccess(auditMappingUnit);
        }
        return super.selectFailed();
    }
        
    /**
    * @Description: 审核注册待审核的测绘单位
    * @Param: [mappingUnit]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PostMapping("auditMappingUnit")
    public ResultData auditMappingUnit(@RequestBody MappingUnit mappingUnit) {
        Integer integer = iUserService.auditMappingUnit(mappingUnit);
        if (integer > 0) {
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
}