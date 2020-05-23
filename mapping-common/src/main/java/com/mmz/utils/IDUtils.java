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
    * @Description: 为了防止被实例化而创建的私有构造方法
     *  工具类是一系列静态成员变量或者方法的集合，意味没必要进行实例化，因为静态方法通过类就可以调用到
     *  没必要再去浪费内存来实例化工具类的实例对象
     *  即使是抽象的工具类，它可以被继承从而实现实例化，但是也不可以有公共的构造方法
     *
     *  而当类中没有声明构造方法的时候，会默认生成一个public类型的无参构造方法，
     *  所以需要声明一个私有的无参构造方法，防止被实例化
    * @Param: []
    * @return:
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    private IDUtils() {
        /**
         * 虽然private修饰，外部类无法实例化该类，但是内部类还是可以实例化该类
         * 通过反射的方法也可以实例化该类
         * 所以在私有的构造器中 添加一个异常，当执行构造方法的时候就会抛出异常，从而停止实例化
         */
        throw new AssertionError();
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