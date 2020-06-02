package com.mmz.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: spring-cloud-mapping
 * @description: 获取当前访问者的IP工具类
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

    private static final String UNKNOWN = "unknown";
    
    /**
    * @Description: 获取当前系统的IP
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

    
    /**
    * @Description: 通过请求来判断当前用户的IP地址
     *      有可能会使用Apache、Squid、Nginx。。对服务器的请求进行代理
     *      经过代理之后，由于在客户端和服务之间增加了中间层，所以服务器无法直接获取到客户端的ip
     *      服务器端也就无法直接通过请求转发的地址返回给客户端
     *      但是在请求转发的http头信息中，增加了x-forwarded-for信息，用以跟踪原有客户端IP地址和
     *      原来客户端请求的服务器地址
    * @Param: [request]
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static String getIpAddr(HttpServletRequest request) {
        // 用户的ip地址都可以获取的到x-forwarded-for就是ip地址
        // 如果在配置文件中将forewared-for改为off 则获取到额结果就为unknown
        String ip = request.getHeader("x-forwarded-for");
        // 需要进行严谨性判断，对用户使用的代理服务器进行判断(本地代理服务器或者网络代理服务器)
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            // 0:0:0:1.. 127.0.0.1
            // 如果存在代理服务器的情况下getRemoteAddr()方法获取的IP实际上是代理服务器的地址
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }
}