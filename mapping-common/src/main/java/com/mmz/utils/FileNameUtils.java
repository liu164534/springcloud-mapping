package com.mmz.utils;

import java.util.Random;

/**
 * @program: spring-cloud-mapping
 * @description: 生成文件名工具类
 * @author: Liu Xinpeng
 * @create: 2020-06-03 17:51
 **/
public class FileNameUtils {
    
    private FileNameUtils() {
        throw new AssertionError();
    }
    
    /**
    * @Description: 生成文件名
    * @Param: []
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    public static String getFileName() {
        // 1.获取系统当前时间的毫秒数
        Long timeMills = System.currentTimeMillis();
        // 2.生成一个0~999之间的随机数
        Random random = new Random();
        Integer randomNum = random.nextInt(999);
        // 3.将获取到的系统的毫秒数和随机数进行拼接，获得新的文件名
        /**
         * %：占位符
         * d：数字
         * 03：三位数，如果不够三位自动向前补0
         */
        String fileName = timeMills + String.format("%03d", randomNum);
    System.out.println(fileName);
        return fileName;
    }
}