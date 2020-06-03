package com.mmz.controller;

import com.github.pagehelper.PageInfo;
import com.mmz.base.BaseController;
import com.mmz.model.Dict;
import com.mmz.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-05-29 09:44
 * @Description: 字典管理
 **/
@RestController
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    /**
     * @author Jia Hao Hao
     * @param [pageNo, pageSize]
     * @date 2020/5/28
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 分页查询所有字典表信息
     * @throws
     **/
    @PostMapping("/selectDictInfo")
    public PageInfo<Dict> selectDictInfo(@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        PageInfo<Dict> dictPageInfo = dictService.selectDictInfo(pageNo, pageSize);
        if (!"".equals(dictPageInfo) && null != dictPageInfo){
            return dictPageInfo;
        }
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 按条件分页查询所有字典表信息
     * @throws
     **/
    @PostMapping("/selectPageDict")
    public PageInfo<Dict> selectPageDict(@RequestBody Dict dict,@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        //按条件分页查询所有字典表信息
        PageInfo<Dict> dictPageInfo = dictService.selectPageDict(dict,pageNo, pageSize);
        if (!"".equals(dictPageInfo) && null != dictPageInfo){
            return dictPageInfo;
        }
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/29
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 分页获取所有字典表数据
     * @throws
    **/
    @GetMapping("/selectAllDictInfo")
    public List<Dict> selectAllDictInfo(){
        //查询字典表所有信息
        List<Dict> dictList = dictService.selectAllDictInfo();
        //判断是否获取到数据
        if(!"".equals(dictList) && null != dictList){
            //有数据则返回
            return dictList;
        }
        //没有数据返回空
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return int
     * @throws
     * @description 新增字典信息
     **/
    @PostMapping("/insertDictInfo")
    public Boolean insertDictInfo(@RequestBody Dict dict){
        return dictService.insertDictInfo(dict);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return int
     * @throws
     * @description 批量删除字典信息
     **/
    @DeleteMapping("/deleteDictInfo")
    public Integer deleteDictInfo(@RequestBody List<Object> ids){
        return dictService.deleteDictInfo(ids);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id删除字典信息
     **/
    @DeleteMapping("/deleteDictId")
    public Integer deleteDictId(@RequestBody Dict dict) {
        return dictService.deleteDictId(dict);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id查询字典信息
     **/
    @PostMapping("/selectDictId")
    public Dict selectDictId(@RequestBody Dict dict){
        return dictService.selectDictId(dict);
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id修改字典信息
     **/
    @PutMapping("/updateDictInfo")
    public Integer updateDictInfo(@RequestBody Dict dict){
        return dictService.updateDictInfo(dict);
    }
}
