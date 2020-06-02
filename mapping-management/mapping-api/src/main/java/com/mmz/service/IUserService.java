package com.mmz.service;

import com.mmz.base.ResultData;
import com.mmz.model.Dict;
import com.mmz.model.User;
import com.mmz.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-cloud-mapping
 * @description: fallbackFactory:就是用来实现熔断的，在实际开发过程中，开发阶段不能开启熔断
 * 因为一旦开启了熔断，整个系统运行过程中异常就不再抛出，不方便调试BUG
 * <p>
 * <p>
 * 实际开发中需要注意的东西：
 * 无论是springcloud1.x版本还是2.x版本
 * 一旦使用feign来传递参数的时候，都需要注意以下两点：
 * 1.如果是简单的数据类型（java8大基本数据类型--基本数据类型的包装类也可以，String）-->需要使用注解@RequestParm
 * 基本数据类型可以传多个，也就是说一个方法的参数中可以使用多个@PRequestParm注解
 * <p>
 * 2.如果是传递包装类型（List,Map,Vo,Po）,只能传递一个，而且必须使用@RequestBody注解
 * <p>
 * 也就是说最终把这些参数值传递到provider项目的controller中，所以provider的controller中也必须使用相同的注解
 * 而且provider要和api中的方法一模一样（方法名、返回值类型、参数类型。。）
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:09
 **/

/**
 * 标识出当前调用的是服务场中的哪个服务，这个服务器名在目标服务器中的--》 “spring.application.name”属性
 */
@FeignClient(value = "system-interface")
public interface IUserService {


    /**
     * @Description: 执行登陆操作
     * @Param: [user]
     * @return: com.mmz.vo.TokenVo
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /**
     * @Description: 添加登陆日志
     * @Param: [map]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/28
     */
    @PostMapping("/addLoginLog")
    ResultData addLoginLog(@RequestBody Map map);

    /**
     * @Description: 查询用户信息
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Mr.miao
     * @Date: 2020/5/28
     */
    @GetMapping("getAllUserInfo")
    List<User> getAllUserInfo();

    /**
     * @Description: 添加用户信息
     * @Param: [user]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/5/31
     */
    @PostMapping("insertUser")
    Boolean insertUser(@RequestBody User user);

    /**
     * @Description: 修改用户信息
     * @Param: [user]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/1
     */
    @PostMapping("updateUser")
    Boolean updateUserInfoById(@RequestBody User user);

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