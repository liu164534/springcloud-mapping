package com.mmz.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    * @Description: 获取当前系统时间，精确到秒
    * @Param: [date]
    * @return: java.lang.String 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/25
    */
    public static final String getDateTime() {
        // 设置日期的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String formatDate = simpleDateFormat.format(new Date());
        return formatDate;
    }


    /**
    * @Description: 获取当前系统时间，精确到天
    * @Param: []
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static final String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        String formatDate = simpleDateFormat.format(new Date());
        return formatDate;
    }

    /**
    * @Description: 默认按照YYYY_MM_DD_HH_MM_SS的格式进行转换
    * @Param: [date]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static final String formatDate(Object date) {
        if (null == date) {
            return null;
        } else {
            return formatDate(date, YYYY_MM_DD_HH_MM_SS);
        }
    }
    /**
    * @Description: 按照指定的格式对日期进行转换
    * @Param: [date, formatType]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static final String formatDate(Object date, String formatType) {
        if (null == date) {
            return null;
        } else {
            if (StringUtils.isNotEmpty(formatType)) {
                // 说明传递了具体的格式，需要按照传递的格式进行转换
                SimpleDateFormat format = new SimpleDateFormat(formatType);
                return format.format(date);
            } else {
                // 说明没有传递具体的格式类型，所以按照默认的格式进行转换
                // 这里直接返回null容易出现类型转换异常
                return formatDate(date);
            }
        }
    }

    /**
    * @Description: 获取当前年数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static Integer getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
    * @Description: 将传递的时间参数，转换成对应单位的格式
    * @Param: [millisecond]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/6/1
    */
    public static String formatDateAgo(long millisecond) {
        StringBuilder stringBuilder = new StringBuilder();
        if (1000 > millisecond) {
            // 说明传递的时间单位为毫秒
            stringBuilder.append(millisecond).append("毫秒");
        } else {
            // 说明传进来的long类型的毫秒数大于1000
            // 设置对应的时间格式
            // 毫秒
            Integer ss =1000;
            // 分钟
            Integer mi = ss * 60;
            // 小时
            Integer hh = mi * 60;
            // 天
            Integer dd = hh * 24;

            Long day = millisecond / dd;
            Long hour = (millisecond - day * dd) / hh;
            Long minute = (millisecond - day * dd - hour * hh) / mi;
            Long second = (millisecond - day * dd - hour *hh - minute * mi) / ss;
            if (day > 365) {
                return formatDate(new Date(millisecond), "yyyy年MM月dd日 HH时mm分ss秒");
            }
            if(day > 0) {
                stringBuilder.append(day).append("天");
            }
            if(hour > 0) {
                stringBuilder.append(hour).append("小时");
            }
            if(minute > 0) {
                stringBuilder.append(minute).append("分钟");
            }
            if(second > 0) {
                stringBuilder.append(second).append("秒");
            }
        }
        return stringBuilder.toString();
    }
}
