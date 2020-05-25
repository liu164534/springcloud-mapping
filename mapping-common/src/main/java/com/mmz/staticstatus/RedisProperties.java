package com.mmz.staticstatus;

/**
 * @program: spring-cloud-mapping
 * @description: redis的静态常量
 * @author: Liu Xinpeng
 * @create: 2020-05-21 13:51
 **/
public class RedisProperties {

    // 不存在这个key才创建
    public static final String NX = "nx";
    // 存在这个key才创建
    public static final String XX = "xx";
    // 秒
    public static final String EX = "ex";
    // 毫秒
    public static final String PX = "px";
    public static final String NO = "no";
    // 默认的value值
    public static final String VALUE = "mmz";
}