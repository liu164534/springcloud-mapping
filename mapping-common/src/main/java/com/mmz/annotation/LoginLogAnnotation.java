package com.mmz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: spring-cloud-mapping
 * @description: 自定义注解
 *          实现自定义注解必须要添加两个注解
 *          1：@Target:标识了该注解所作用的位置（范围）
 *              TYPE:作用于类
 *              METHOD:作用于方法
 *              FIELD:作用于属性
 *          2：@Retention:标识该注解什么时候生效
 *              RUNTIME：项目运行时生效
 *              TEST:测试时生效
 *              。。。
 * @author: Liu Xinpeng
 * @create: 2020-05-28 08:56
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLogAnnotation {

    /**
    * @Description: 需要执行的操作类型
     *      eg:
     *          delete操作，login操作，register注册操作。。。
    * @Param: []
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    String operationType() default "";


    /**
    * @Description: 要执行具体操作的内容：
     *      eg：
     *          删除用户操作，删除图书操作。。
    * @Param: []
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    String operationName() default "";
}