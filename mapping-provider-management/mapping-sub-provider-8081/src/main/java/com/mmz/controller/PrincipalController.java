package com.mmz.controller;

import com.mmz.base.BaseService;
import com.mmz.base.CommonController;
import com.mmz.model.Principal;
import com.mmz.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-06-03 20:41
 * @Description:
 **/
@RestController
public class PrincipalController extends CommonController<Principal> {
    @Autowired
    private PrincipalService principalService;
    @Override
    public BaseService<Principal> getBaseService() {
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取单位负责人信息
     **/
    @PostMapping("/selectAllPrincipal")
    public List<Principal> selectAllPrincipal(@RequestBody Principal userId){
        List<Principal> principals = principalService.selectAllPrincipal(userId);
        if (principals.size() > 0){
            return principals;
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
    @PostMapping("/insertPrincipal")
    public Integer insertPrincipal(@RequestBody Principal principal){
        Integer integer = principalService.insertPrincipal(principal);
        if (integer > 0 && null != integer){
            return integer;
        }
        return null;
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
    public Integer deletePrincipal(@RequestBody Principal principal){
        Integer integer = principalService.deletePrincipal(principal);
        if (integer > 0 && null != integer){
            return integer;
        }
        return null;
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
    public Integer updatePrincipal(@RequestBody Principal principal){
        Integer integer = principalService.updatePrincipal(principal);
        if (integer > 0 && null != integer){
            return integer;
        }
        return null;
    }
}
