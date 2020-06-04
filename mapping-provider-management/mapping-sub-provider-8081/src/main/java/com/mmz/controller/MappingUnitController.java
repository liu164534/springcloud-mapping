package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.MappingUnit;
import com.mmz.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: provider-测绘单位
 * @author: Liu Xinpeng
 * @create: 2020-06-03 09:35
 **/
@RestController
public class MappingUnitController extends CommonController {
    @Override
    public BaseService getBaseService() {
        return mappingUnitService;
    }
    @Autowired
    private MappingUnitService mappingUnitService;

    /**
    * @Description: 根据条件获取测绘单位名称
    * @Param: [mappingUnit]
    * @return: java.util.List<com.mmz.model.MappingUnit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    @PostMapping("getMappingUnitName")
    public List<MappingUnit> getMappingUnitName(@RequestBody MappingUnit mappingUnit) {
        List<MappingUnit> mappingUnits = mappingUnitService.getMappingUnitName(mappingUnit);
        return mappingUnits;
    }
    
    /**
    * @Description: 首页添加测绘部门
    * @Param: [mappingUnit]
    * @return: java.lang.Integer 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PutMapping("addMappingUnit")
    public Integer addMappingUnit(@RequestBody MappingUnit mappingUnit) {
        Integer integer = mappingUnitService.addMappingUnit(mappingUnit);
        return integer;
    }

    /**
    * @Description: 查询注册待审核的企业
    * @Param: []
    * @return: java.util.List<com.mmz.model.MappingUnit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @GetMapping("getAuditMappingUnit")
    public List<MappingUnit> getAuditMappingUnit() throws Exception {
        MappingUnit mappingUnit = new MappingUnit();
        mappingUnit.setAuditStatus(2);
        List<MappingUnit> mappingUnits = mappingUnitService.queryList(mappingUnit);
        return mappingUnits;
    }
    
    /**
    * @Description: 审核注册的测绘单位
    * @Param: [mappingUnit]
    * @return: java.lang.Integer 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PostMapping("auditMappingUnit")
    Integer auditMappingUnit(@RequestBody MappingUnit mappingUnit) {
        mappingUnit.setAuditStatus(3);
        Integer integer = mappingUnitService.addMappingUnit(mappingUnit);
        return integer;
    }
}