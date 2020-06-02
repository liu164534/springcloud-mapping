package com.mmz.service;

import com.mmz.model.Dict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-06-02 22:02
 **/
@FeignClient(value = "system-interface")
@Component
public interface IDictService {
//    /**
//     * @author Jia Hao Hao
//     * @param
//     * @date 2020/5/29
//     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
//     * @description 分页获取字典表数据
//     * @throws
//     **/
//    @PostMapping("/selectDictInfo")
//    PageInfo<Dict> selectDictInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/29
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 获取所有字典表数据
     * @throws
     **/
    @GetMapping("/selectAllDictInfo")
    List<Dict> selectAllDictInfo();

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return int
     * @throws
     * @description 新增字典信息
     **/
    @PostMapping("/insertDictInfo")
    Boolean insertDictInfo(@RequestBody Dict dict);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return int
     * @throws
     * @description 批量删除字典信息
     **/
    @DeleteMapping("/deleteDictInfo")
    Integer deleteDictInfo(@RequestBody List<Object> ids);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id删除字典信息
     **/
    @DeleteMapping("/deleteDictId")
    Integer deleteDictId(@RequestBody Dict dict);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id查询字典信息
     **/
    @PostMapping("/selectDictId")
    Dict selectDictId(@RequestBody Dict dict);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id修改字典信息
     **/
    @PutMapping("/updateDictInfo")
    Integer updateDictInfo(@RequestBody Dict dict);
}