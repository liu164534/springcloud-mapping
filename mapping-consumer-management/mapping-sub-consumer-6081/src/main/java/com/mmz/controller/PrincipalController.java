package com.mmz.controller;

import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Principal;
import com.mmz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-03 20:47
 * @Description: 单位负责人信息
 **/
@RestController
public class PrincipalController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取单位负责人信息
     **/
    @PostMapping("/selectAllPrincipal")
    public ResultData selectAllPrincipal(@RequestBody Principal userId){
        List<Principal> principals = iUserService.selectAllPrincipal(userId);
        if (principals.size() > 0){
            return super.selectSuccess(principals);
        }
        return super.selectFailed();
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加单位负责人信息
     **/
    @PostMapping("/insertPrincipal")
    public ResultData insertPrincipal(@RequestBody Principal principal){
        Integer integer = iUserService.insertPrincipal(principal);
        if (null != integer && integer > 0){
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
     * @description  删除仪单位负责人信息
     **/
    @DeleteMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        Integer integer = iUserService.deletePrincipal(principal);
        if (null != integer && integer > 0){
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
     * @description  修改单位负责人信息
     **/
    @PutMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal){
        Integer integer = iUserService.updatePrincipal(principal);
        if (null != integer && integer > 0){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }

}
