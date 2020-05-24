package com.mmz.service;

import com.mmz.model.User;
import com.mmz.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: spring-cloud-mapping
 * @description:
 *      fallbackFactory:就是用来实现熔断的，在实际开发过程中，开发阶段不能开启熔断
 *      因为一旦开启了熔断，整个系统运行过程中异常就不再抛出，不方便调试BUG
 *
 *
 *      实际开发中需要注意的东西：
 *          无论是springcloud1.x版本还是2.x版本
 *          一旦使用feign来传递参数的时候，都需要注意以下两点：
 *          1.如果是简单的数据类型（java8大基本数据类型--基本数据类型的包装类也可以，String）-->需要使用注解@RequestParm
 *              基本数据类型可以传多个，也就是说一个方法的参数中可以使用多个@PRequestParm注解
 *
 *          2.如果是传递包装类型（List,Map,Vo,Po）,只能传递一个，而且必须使用@RequestBody注解
 *
 *          也就是说最终把这些参数值传递到provider项目的controller中，所以provider的controller中也必须使用相同的注解
 *              而且provider要和api中的方法一模一样（方法名、返回值类型、参数类型。。）
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:09
 **/

/**
 * 标识出当前调用的是服务场中的哪个服务，这个服务器名在目标服务器中的--》 “spring.application.name”属性
 */
@FeignClient(value = "system-interface")
public interface IMMZService {

    
    /**
    * @Description: 执行登陆操作
    * @Param: [user]
    * @return: com.mmz.vo.TokenVo 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);
}