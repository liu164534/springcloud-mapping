package com.mmz.service;

import com.github.pagehelper.PageInfo;
import com.mmz.base.ResultData;
import com.mmz.model.*;
import com.mmz.vo.TokenVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
 *
 * 这里还有个path属性，相同服务名，可以通过不同的path来对接口的路径进行区分
 */
@FeignClient(value = "system-interface-8081")
@Component
public interface IUserService {


    /**
     * @Description: 执行登陆操作
     * @Param: [user]
     * @return: com.mmz.vo.TokenVo
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    @PostMapping("/doLogin")
    @HystrixCommand
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

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/29
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 分页获取字典表数据
     * @throws
     **/
    @PostMapping("/selectDictInfo")
    PageInfo<Dict> selectDictInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 按条件分页查询所有字典表信息
     * @throws
     **/
    @PostMapping("/selectPageDict")
    PageInfo<Dict> selectPageDict(@RequestBody Dict dict,@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize);

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


    /**
     * @Description: 根据条件查询测绘项目的名称
     * @Param: [mappingProject]
     * @return: com.mmz.model.MappingProject
     * @Author: Liu Xinpeng
     * @Date: 2020/6/2
     */
    @PostMapping("/getMappingProjectName")
    List<MappingProject> getMappingProjectName(@RequestBody MappingProject mappingProject);

    /**
     * @Description: 根据条件查询测绘单位的名称
     * @Param: [mappingUnit]
     * @return: java.util.List<com.mmz.model.MappingUnit>
     * @Author: Liu Xinpeng
     * @Date: 2020/6/3
     */
    @PostMapping("getMappingUnitName")
    List<MappingUnit> getMappingUnitName(@RequestBody MappingUnit mappingUnit);


    /**
     * @Description: 根据条件查询测绘成果
     * @Param: [resultCommit]
     * @return: java.util.List<com.mmz.model.ResultCommit>
     * @Author: Liu Xinpeng
     * @Date: 2020/6/3
     */
    @PostMapping("getResultCommitName")
    List<ResultCommit> getResultCommitName(@RequestBody ResultCommit resultCommit);

    /**
     * @Description: ftp文件上传
     *      file文件是无法发送到provider项目中的，因为feign默认只能支持发送普通类型的数据
     *      (java8种基本数据类型和包装类、封装类型、集合。。)这些普通类型的数据都可以转换成为二进制流的形式
     *      在http之间进行传输，但是文件类型不行，因为文件类型只能转换为字节/字符流
     *      所以让PostMapping接收Multipart/form-data
     *      让feign接收json格式的数据
     *
     * @Param: [multipartFile]
     * @return: java.lang.Boolean
     * @Author: Liu Xinpeng
     * @Date: 2020/6/3
     */
    @PostMapping(value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(@RequestBody MultipartFile multipartFile);

    /**
     * @Description: 获取角色的所有信息
     * @Param: []
     * @return: java.util.List<com.mmz.model.Role>
     * @Author: Mr.miao
     * @Date: 2020/6/3
     */
    @GetMapping("selectAllRole")
    List<Role> selectAllRole();


    /**
     * @Description: 添加角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("insertRole")
    Boolean insertRole(@RequestBody Role role) ;

    /**
     * @Description: 修改角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("updateRole")
    Boolean updateRole(@RequestBody Role role) ;

    /**
     * @Description: 删除角色
     * @Param: [role]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("deleteRole")
    Boolean deleteRole(@RequestBody Role role) ;

    /**
     * @Description: 查询菜单
     * @Param: []
     * @return: java.util.List<com.mmz.model.Menu>
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @GetMapping("getAllMenu")
    List<Menu> getAllMenu();

    /**
     * @Description: 添加按钮
     * @Param: [menu]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("insertMenu")
    Boolean insertMenu(@RequestBody Menu menu);
    /**
     * 删除菜单
     * @Description:
     * @Param: [menu]
     * @return: java.lang.Boolean
     * @Author: Mr.miao
     * @Date: 2020/6/4
     */
    @PostMapping("deleteMenu")
    Boolean deleteMenu(Menu menu);

    /**
     * @Description: 根据id删除部门
     * @Param: [dept]
     * @return: java.lang.Integer
     * @Author: Thanks
     * @Date: 2020/6/4
     */
    @PostMapping("/deleteDeptId")
    Integer deleteDeptId(@RequestBody Dept dept);

    /**
     * @Description: 查询所有部门
     * @Param: []
     * @return: java.util.List<com.mmz.model.Dept>
     * @Author: Thanks
     * @Date: 2020/6/4
     */
    @GetMapping("/selectAllDept")
    List<Dept> selectAllDept();
    /**
     * @Description: 新增部门
     * @Param: [dept]
     * @return: boolean
     * @Author: Thanks
     * @Date: 2020/6/4
     */
    @PostMapping("/insertDept")
    boolean insertDept(@RequestBody Dept dept);
    /**
     *@Description: 批量删除部门
     *@Param: [depts]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/deleteDepts")
    Integer deleteDepts(@RequestBody List<Object> depts);

    /**
     *@Description: 修改部门信息
     *@Param: [dept]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/3
     */
    @PostMapping("/updateDept")
    Integer updateDept(@RequestBody Dept dept);


    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  获取所有仪器设备信息
     **/
    @PostMapping("/selectEquipment")
    List<Equipment> selectAllEquipment(@RequestBody Equipment userId);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加仪器设备信息
     **/
    @PostMapping("/insertEquipment")
    Boolean insertEquipment(@RequestBody Equipment equipment);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪器设备信息
     **/
    @DeleteMapping("/deleteEquipment")
    Boolean deleteEquipment(@RequestBody Equipment equipment);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改仪器设备信息
     **/
    @PostMapping("/updateEquipment")
    Boolean updateEquipment(@RequestBody Equipment equipment);

    /**
     * @Description: 根据主键删除用户
     * @Param: [user]
     * @return: java.lang.Boolean
     * @Author: Liu Xinpeng
     * @Date: 2020/6/4
     */
    @PostMapping("deleteUserById")
    Boolean deleteUserById(@RequestBody User user);


    /**
     * @Description: 首页注册测绘单位
     * @Param: [mappingUnit]
     * @return: java.lang.Integer
     * @Author: Liu Xinpeng
     * @Date: 2020/6/4
     */
    @PutMapping("addMappingUnit")
    Integer addMappingUnit(@RequestBody MappingUnit mappingUnit);


    /**
     *@Description: 新增项目
     *@Param: [mappingProject]
     *@return: java.lang.Boolean
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/insertMappingProject")
    Boolean insertMappingProject(@RequestBody MappingProject mappingProject);

    /**
     *@Description: 修改项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/updateMappingProject")
    Integer updateMappingProject(@RequestBody MappingProject mappingProject);

    /**
     *@Description: 删除项目
     *@Param: [mappingProject]
     *@return: java.lang.Integer
     *@Author: Thanks
     *@date: 2020/6/4
     */
    @PostMapping("/deleteMappingProject")
    Integer deleteMappingProject(@RequestBody MappingProject mappingProject);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取所有技术人员信息
     **/
    @PostMapping("/selectAllTechnicist")
    List<Technicist> selectAllTechnicist(@RequestBody Technicist technicist);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加技术人员信息
     **/
    @PostMapping("/insertTechnicist")
    Boolean insertTechnicist(@RequestBody Technicist technicist);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪器设备信息
     **/
    @DeleteMapping("/deleteTechnicist")
    Boolean deleteTechnicist(@RequestBody Technicist technicist);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改仪器设备信息
     **/
    @PostMapping("/updateTechnicist")
    Boolean updateTechnicist(@RequestBody Technicist technicist);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  根据uiseId获取单位负责人信息
     **/
    @PostMapping("/selectAllPrincipal")
    List<Principal> selectAllPrincipal(@RequestBody Principal userId);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  添加单位负责人信息
     **/
    @PostMapping("/insertPrincipal")
    Integer insertPrincipal(@RequestBody Principal principal);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  删除仪单位负责人信息
     **/
    @DeleteMapping("/deletePrincipal")
    Integer deletePrincipal(@RequestBody Principal principal);

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/6/2
     * @return java.util.List<com.mmz.model.Equipment>
     * @throws
     * @description  修改单位负责人信息
     **/
    @PutMapping("/updatePrincipal")
    Integer updatePrincipal(@RequestBody Principal principal);
    
    /**
    * @Description: 查询注册待审核的测绘单位
    * @Param: []
    * @return: java.util.List<com.mmz.model.MappingUnit> 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @GetMapping("getAuditMappingUnit")
    List<MappingUnit> getAuditMappingUnit();
    
    
    /**
    * @Description: 审核注册的测绘单位
    * @Param: [mappingUnit]
    * @return: java.lang.Integer 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/4
    */
    @PostMapping("auditMappingUnit")
    Integer auditMappingUnit(@RequestBody MappingUnit mappingUnit);
}
