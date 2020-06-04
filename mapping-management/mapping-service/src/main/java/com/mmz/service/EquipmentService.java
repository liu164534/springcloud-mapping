package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.EquipmentMapper;
import com.mmz.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-02 19:31
 * @Description: 单位基本信息————仪器设备信息
 **/
@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取所有仪器设备信息
    **/
    public List<Equipment> selectAllEquipment(Equipment userId){
        //获取所有仪器设备信息
        List<Equipment> equipment = equipmentMapper.select(userId);
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
     * @description  添加仪器设备信息
     **/
    public Boolean insertEquipment(Equipment equipment){
        //判断是否有数据
        if("".equals(equipment) && null == equipment){
            return false;
        }else {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            equipment.setCreateTime(format);
            int insert = equipmentMapper.insert(equipment);
            if (insert > 0){
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪器设备信息
     **/
    public Boolean deleteEquipment(Equipment equipment){
        if ("".equals(equipment) && null == equipment) {
            return false;
        } else {
            int i = equipmentMapper.deleteByPrimaryKey(equipment);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改仪器设备信息
     **/
    public Boolean updateEquipment(Equipment equipment){
        if ("".equals(equipment) && null == equipment) {
            return false;
        } else {
            int i = equipmentMapper.updateByPrimaryKey(equipment);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
