package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.PrincipalMapper;
import com.mmz.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-03 20:10
 * @Description: 单位负责人管理
 **/
@Service
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;
    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取单位负责人信息
     **/
    public List<Principal> selectAllPrincipal(Principal userId){
        //获取所有仪器设备信息
        List<Principal> equipment = principalMapper.select(userId);
        //判断是否获取到数据
        if (null !=  equipment && equipment.size() > 0){
            return equipment;
        }
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加单位负责人信息
     **/
    public Integer insertPrincipal(Principal principal){
        //判断是否有数据
        if("".equals(principal) && null == principal){
            return null;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            principal.setCreateTime(format);
            int insert = principalMapper.insert(principal);
            if (insert > 0){
                return insert;
            } else{
                return null;
            }
        }
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪单位负责人信息
     **/
    public Integer deletePrincipal(Principal principal){
        if ("".equals(principal) && null == principal) {
            return null;
        } else {
            int i = principalMapper.deleteByPrimaryKey(principal);
            if (i > 0) {
                return i;
            } else {
                return null;
            }
        }
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改单位负责人信息
     **/
    public Integer updatePrincipal(Principal principal){
        if ("".equals(principal) && null == principal) {
            return null;
        } else {
            int i = principalMapper.updateByPrimaryKey(principal);
            if (i > 0) {
                return i;
            } else {
                return null;
            }
        }
    }
}
