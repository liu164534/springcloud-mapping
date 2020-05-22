package com.mmz.utils;

import java.util.UUID;

/**
 * @program: spring-cloud-mapping
 * @description: 生成uuid的工具类
 * @author: Liu Xinpeng
 * @create: 2020-05-21 14:02
 **/
public class IDUtils {
    /**
     * TODO 这个私有的无参构造方法的作用还不明白
     */
    private IDUtils() {

    }

    /**
    * @Description: 获取uuid
    * @Param: []
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}