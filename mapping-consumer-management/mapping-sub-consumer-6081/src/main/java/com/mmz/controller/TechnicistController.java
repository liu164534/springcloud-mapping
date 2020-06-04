package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Technicist;
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
 * @Date: 2020-06-04 10:40
 * @Description: 技术人员信息管理
 **/
@RestController
@Api(value = "技术人员信息" ,tags = "技术人员信息接口")
public class TechnicistController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取所有技术人员信息
     **/
    @PostMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestBody Technicist technicist){
        List<Technicist> technicists = iUserService.selectAllTechnicist(technicist);
        if (!"".equals(technicists) && null != technicists){
            return super.selectSuccess(technicist);
        }
        return super.selectFailed();
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加技术人员信息
     **/
    @PostMapping("/insertTechnicist")
    public ResultData insertTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = iUserService.insertTechnicist(technicist);
        if (aBoolean){
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
    @DeleteMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = iUserService.deleteTechnicist(technicist);
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
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = iUserService.updateTechnicist(technicist);
        if (aBoolean){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
}
