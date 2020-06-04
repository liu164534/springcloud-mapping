package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Equipment;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-02 20:17
 * @Description: 单位基本信息————仪器设备信息
 **/
@RestController
@Api(value = "仪器设备",tags = "仪器设备接口")
public class EquipmentController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  获取所有仪器设备信息
     **/
    @PostMapping("/selectEquipment")
    public ResultData selectAllEquipment(@RequestBody Equipment userId){
        List<Equipment> equipment = iUserService.selectAllEquipment(userId);
        // 判断是否获取到数据
        if (!"".equals(equipment) && null != equipment) {
            // 有数据则返回
            return super.selectSuccess(equipment);
        }
        // 没有数据返回失败
        return super.selectFailed();
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
    public ResultData insertEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = iUserService.insertEquipment(equipment);
        if(aBoolean){
            return super.insertSuccess();
        }
        return super.insertFailed();
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
    public ResultData deleteEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = iUserService.deleteEquipment(equipment);
        if (aBoolean){
            return super.deleteSuccess();
        }
        return super.deleteFailed();
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
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        Boolean aBoolean = iUserService.updateEquipment(equipment);
        if (aBoolean){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
}
