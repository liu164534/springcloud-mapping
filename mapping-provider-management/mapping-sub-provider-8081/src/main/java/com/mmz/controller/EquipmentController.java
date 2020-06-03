package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.Equipment;
import com.mmz.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-02 20:05
 * @Description: 单位基本信息————仪器设备信息
 **/
@RestController
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Override
    public BaseService<Equipment> getBaseService() {
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  获取所有仪器设备信息
     **/
    @PostMapping("/selectEquipment")
    public List<Equipment> selectAllEquipment(@RequestBody Equipment userId){
        return equipmentService.selectAllEquipment(userId);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加仪器设备信息
     **/
    @PostMapping("/insertEquipment")
    public Boolean insertEquipment(@RequestBody Equipment equipment){
        return equipmentService.insertEquipment(equipment);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪器设备信息
     **/
    @DeleteMapping("/deleteEquipment")
    public Boolean deleteEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = equipmentService.deleteEquipment(equipment);
        if (aBoolean) {
            return true;
        } else {
            return false;
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
    @PostMapping("/updateEquipment")
    public Boolean updateEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = equipmentService.updateEquipment(equipment);
        if (aBoolean) {
            return true;
        } else {
            return false;
        }
    }
}
