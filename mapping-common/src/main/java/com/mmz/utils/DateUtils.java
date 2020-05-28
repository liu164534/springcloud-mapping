package com.mmz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.mmz.staticstatus.DateProperties.*;
/**
 * @program: spring-cloud-mapping
 * @description: 将时间转换成String类型
 * @author: Liu Xinpeng
 * @create: 2020-05-25 22:30
 **/
public class DateUtils {

    /**
    * @Description: 防止被创建实例
    * @Param: []
    * @return:
    * @Author: Liu Xinpeng
    * @Date: 2020/5/25
    */
    private DateUtils(){
        throw new AssertionError();
    }
    
    /**
    * @Description: 将时间以对应得格式转换成String类型
    * @Param: [date]
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/25
    */
    public static final String getDate() {
        // 设置日期得格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String formatDate = simpleDateFormat.format(new Date());
        return formatDate;
    }
}