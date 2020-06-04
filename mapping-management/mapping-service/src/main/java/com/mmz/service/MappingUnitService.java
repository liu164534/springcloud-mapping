package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.MappingUnitMapper;
import com.mmz.mapper.UserInfoMapper;
import com.mmz.model.MappingUnit;
import com.mmz.model.User;
import com.mmz.utils.DateUtils;
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

    @Autowired
    private UserInfoMapper userInfoMapper;

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
        // 测绘单位注册之后，先注册一个登陆账号
        User user = new User();
        user.setUsername(mappingUnit.getUnitName());
        // 默认的登陆密码123456
        user.setPassword("123456");
        user.setEmail(mappingUnit.getEmail());
        user.setStatus("1");
        user.setCreateTime(DateUtils.getDate());
        user.setType("0");
        Long keys = userInfoMapper.insertUseGeneratedKeys(user);
        // 判断添加登陆账号成功后，再进行测绘单位的注册
        if (keys > 0) {
            mappingUnit.setCreateTime(DateUtils.getDate());
            mappingUnit.setUserId(user.getId());
            mappingUnit.setAuditStatus(2);
            mappingUnit.setSynchronizationStatus(1);
            mappingUnit.setUnitStatus(3);
            Integer insert = mappingUnitMapper.insert(mappingUnit);
            if (insert > 0) {
                return insert;
            }
            return 0;
        }
        return 0;
    }
}