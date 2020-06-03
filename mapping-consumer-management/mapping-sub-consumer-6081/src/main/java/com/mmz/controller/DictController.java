package com.mmz.controller;


import com.github.pagehelper.PageInfo;
import com.mmz.base.BaseController;
import com.mmz.base.ResultData;
import com.mmz.model.Dict;
import com.mmz.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring-cloud-mapping
 * @description: consumer的登陆controller
 * @author: Liu Xinpeng
 * @create: 2020-05-24 18:28
 **/
@RestController
@Api(value = "字典信息",tags = "管理字典")
public class DictController extends BaseController {

      @Autowired
      private IUserService iUserService;

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/29
       * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
       * @description 分页获取字典表数据
       * @throws
       **/
      @PostMapping("/selectDictInfo")
      public ResultData selectDictInfo(@RequestParam("pageNo")Integer pageNo ,@RequestParam("pageSize")Integer pageSize){
        //分页获取字典表数据
        PageInfo<Dict> dictPageInfo = iUserService.selectDictInfo(pageNo, pageSize);
          if (!"".equals ( dictPageInfo ) && null != dictPageInfo){
              return super.selectSuccess(dictPageInfo);
          }
          return super.selectFailed();

      }

      /**
       * @author Jia Hao Hao
       * @param [pageNo, pageSize]
       * @date 2020/5/28
       * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
       * @description 按条件分页查询所有字典表信息
       * @throws
       **/
      @PostMapping("/selectPageDict")
      public ResultData selectPageDict(@RequestBody Dict dict,@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
          //按条件分页查询所有字典表信息
          PageInfo<Dict> dictPageInfo = iUserService.selectPageDict(dict,pageNo, pageSize);
          if (!"".equals ( dictPageInfo ) && null != dictPageInfo){
            return super.selectSuccess(dictPageInfo);
          }
          return super.selectFailed();
      }
      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/29
       * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
       * @description 获取所有字典表数据
       * @throws
       */
      @GetMapping("/selectAllDictInfo")
      public ResultData selectAllDictInfo() {
        // 获取字典信息
        List<Dict> dictList = iUserService.selectAllDictInfo();
        // 判断是否获取到数据
        if (!"".equals(dictList) && null != dictList) {
          // 有数据则返回
          return super.selectSuccess(dictList);
        }
        // 没有数据返回失败
        return super.selectFailed();
      }

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/28
       * @return int
       * @throws
       * @description 新增字典信息
       */
      @PostMapping("/insertDictInfo")
      public ResultData insertDictInfo(@RequestBody Dict dict) {
        // 添加字典信息
        Boolean aBoolean = iUserService.insertDictInfo(dict);
        if (aBoolean) {
          // 返回成功
          return super.insertSuccess();
        }
        // 返回失败
        return super.insertFailed();
      }

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/28
       * @return int
       * @throws
       * @description 批量删除字典信息
       */
      @DeleteMapping("/deleteDictInfo")
      public ResultData deleteDictInfo(@RequestBody List<Object> ids) {
        // 批量删除字典信息
        Integer integer = iUserService.deleteDictInfo(ids);
        if (integer > 0) {
          return super.deleteSuccess();
        }
        return super.deleteFailed();
      }

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/28
       * @return java.lang.Boolean
       * @throws
       * @description 根据id删除字典信息
       */
      @DeleteMapping("/deleteDictId")
      public ResultData deleteDictId(@RequestBody Dict dict) {
        // 批量删除字典信息
        Integer integer = iUserService.deleteDictId(dict);
        if (integer > 0) {
          return super.deleteSuccess();
        }
        return super.deleteFailed();
      }

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/28
       * @return java.lang.Boolean
       * @throws
       * @description 根据id查询字典信息
       */
      @PostMapping("/selectDictId")
      public ResultData selectDictId(@RequestBody Dict dict) {
        // 根据id查询字典信息
        Dict dict1 = iUserService.selectDictId(dict);
        if (!"".equals(dict1) && null != dict1) {
          // 查询成功返回数据
          return super.selectSuccess(dict1);
        }
        // 返回失败
        return super.selectFailed();
      }

      /**
       * @author Jia Hao Hao
       * @param
       * @date 2020/5/28
       * @return java.lang.Boolean
       * @throws
       * @description 根据id修改字典信息
       */
      @PutMapping("/updateDictInfo")
      public ResultData updateDictInfo(@RequestBody Dict dict) {
        // 根据id修改字典信息
        Integer integer = iUserService.updateDictInfo(dict);
        if (integer > 0) {
          return super.updateSuccess();
        }
        return super.updateFailed();
      }
}