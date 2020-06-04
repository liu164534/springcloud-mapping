package com.mmz.mapper;

import com.mmz.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 测绘单位
 */
public interface MappingUnitMapper extends Mapper<MappingUnit> {
    
    
    /**
    * @Description: 根据条件获取对应测绘单位的名称
    * @Param: [mappingUnit]
    * @return: java.util.List<com.mmz.model.MappingUnit> 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    List<MappingUnit> getMappingUnitName(MappingUnit mappingUnit);

    /**
    * @Description: 注册测绘单位
    * @Param: [mappingUnit]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    Integer addMappingUnit(MappingUnit mappingUnit);
}