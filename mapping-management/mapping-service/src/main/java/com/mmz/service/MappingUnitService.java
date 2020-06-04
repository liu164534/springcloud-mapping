package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.MappingUnitMapper;
import com.mmz.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: spring-cloud-mapping
 * @description: 测绘单位service
 * @author: Liu Xinpeng
 * @create: 2020-06-03 09:37
 **/
@Service
public class MappingUnitService extends BaseService<MappingUnit> {

    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
    * @Description: 根据条件查询测绘单位名称
    * @Param: [mappingUnit]
    * @return: java.util.List<com.mmz.model.MappingUnit>
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    public List<MappingUnit> getMappingUnitName(MappingUnit mappingUnit) {
        List<MappingUnit> mappingUnits = mappingUnitMapper.getMappingUnitName(mappingUnit);
        if (mappingUnits.size() > 0 && null != mappingUnits) {
            return mappingUnits;
        }
        return null;
    }

    /**
    * @Description: 首页注册测绘单位
    * @Param: [mappingUnit]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    public Integer addMappingUnit(MappingUnit mappingUnit) {
        Integer integer = mappingUnitMapper.addMappingUnit(mappingUnit);
        if (integer > 0) {
            return integer;
        }
        return 0;
    }
}