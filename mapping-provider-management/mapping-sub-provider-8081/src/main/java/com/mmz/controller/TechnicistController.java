package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.Technicist;
import com.mmz.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-04 10:35
 * @Description: 技术人员信息管理
 **/
@RestController
public class TechnicistController extends CommonController<Technicist> {
    @Autowired
    private TechnicistService technicistService;
    @Override
    public BaseService<Technicist> getBaseService() {
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取所有技术人员信息
     **/
    @PostMapping("/selectAllTechnicist")
    public List<Technicist> selectAllTechnicist(@RequestBody Technicist technicist){
        List<Technicist> technicists = technicistService.selectAllTechnicist(technicist);
        if (technicists.size() > 0 ){
            return technicists;
        }
        return null;
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
    public Boolean insertTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = technicistService.insertTechnicist(technicist);
        if (aBoolean){
            return true;
        }
        return false;
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
    public Boolean deleteTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = technicistService.deleteTechnicist(technicist);
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
    @PostMapping("/updateTechnicist")
    public Boolean updateTechnicist(@RequestBody Technicist technicist){
        Boolean aBoolean = technicistService.updateTechnicist(technicist);
        if (aBoolean) {
            return true;
        } else {
            return false;
        }
    }
}
