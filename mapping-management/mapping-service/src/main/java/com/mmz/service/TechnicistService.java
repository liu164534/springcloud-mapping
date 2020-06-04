package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.TechnicistMapper;
import com.mmz.model.Technicist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-04 10:29
 * @Description: 技术人员信息管理
 **/
@Service
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取所有技术人员信息
     **/
    public List<Technicist> selectAllTechnicist(Technicist userId){
        //获取所有仪器设备信息
        List<Technicist> select = technicistMapper.select(userId);
        //判断是否获取到数据
        if (null !=  select && select.size() > 0){
            return select;
        }
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加仪器技术人员信息
     **/
    public Boolean insertTechnicist(Technicist technicist){
        //判断是否有数据
        if("".equals(technicist) && null == technicist){
            return false;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            technicist.setCreateTime(format);
            //执行新增
            int insert = technicistMapper.insert(technicist);
            if (insert > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除技术人员信息
     **/
    public Boolean deleteTechnicist(Technicist technicist){
        if ("".equals(technicist) && null == technicist) {
            return false;
        } else {
            int i = technicistMapper.deleteByPrimaryKey(technicist);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改技术人员信息
     **/
    public Boolean updateTechnicist(Technicist technicist){
        if ("".equals(technicist) && null == technicist) {
            return false;
        } else {
            int i = technicistMapper.updateByPrimaryKey(technicist);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }
}
