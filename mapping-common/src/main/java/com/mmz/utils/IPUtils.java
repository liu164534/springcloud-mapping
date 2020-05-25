package com.mmz.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: spring-cloud-mapping
 * @description: 获取当前访问者的IP
 * @author: Liu Xinpeng
 * @create: 2020-05-25 23:06
 **/
public class IPUtils {
    /**
    * @Description: 将构造器私有化
    * @Param: []
    * @return:
    * @Author: Liu Xinpeng
    * @Date: 2020/5/25
    */
    private IPUtils(){
        throw new AssertionError();
    }
    
    /**
    * @Description: 获取当前访问用户的ip，并转转换成String类型
    * @Param: []
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/25
    */
    public static String getIp() throws UnknownHostException {
            InetAddress localHost = Inet4Address.getLocalHost();
            String ip = localHost.toString();
            return ip;
    }
}