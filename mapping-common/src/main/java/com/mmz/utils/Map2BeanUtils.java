package com.mmz.utils;


import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spring-cloud-mapping
 * @description: map和bean转化的实体类
 * @author: Liu Xinpeng
 * @create: 2020-05-21 14:13
 **/
public class Map2BeanUtils {

    /**
    * @Description: 构造器私有化，方式被实例化
    * @Param: []
    * @return:
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    private Map2BeanUtils() {
        throw new AssertionError();
    }

    // 使用高性能的java实例化工具
    private final static ObjenesisStd OBJENESIS = new ObjenesisStd(true);
    // StringBuffer 的性能比StringBulider ,但是StringBuffer是线程安全的
    private final static StringBuffer STRING_BUFFER = new StringBuffer();
    // 使用Map集合作为本地缓存池使用 (也必须要保证线程安全)
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP =
            new ConcurrentHashMap<Class, MethodAccess>();
    /**
    * @Description: 把map转换成bean对象
    * @Param: [map, tClass]
    * @return: T
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> tClass) {
        // 通过tClass类型获取泛型对象(获取当前所需要的对象--》但是这个对象是一个空对象)
        T instance = OBJENESIS.newInstance(tClass);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(tClass);
        if (null == methodAccess) {
            // TODO 由于通过传入类型泛型获取的对象是一个空对象，所以再对该对象赋予一次类型
            methodAccess = MethodAccess.get(tClass);
            /**
             * Map中是以key和value存在的
             * map.put("username", "zhangsan");
             * map.put("username", "lisi");--->lisi就把zhangsan覆盖了
             * map.putIfAbsent("username", "wangwu");--->wangwu并不会存放，因为username这个key已经存在
             */
            // TODO 获取下一步的get和set方法 (防止为空，所以再进行一次验证)
            CONCURRENT_HASH_MAP.putIfAbsent(tClass, methodAccess);
            // 循环数据
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // 通过循环可以获取到Map中的各种数据，通过setter方法进行赋值
                String setMethodName = setMethodName(entry.getKey());
                int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
                // method.invoke() 用来执行某个对象的目标方法
                methodAccess.invoke(instance, index, entry.getValue());
            }
        }
        return instance;
    }

    /**
    * @Description: 通过字段获取set方法的方法名
    * @Param: [fieldName]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    private static String setMethodName(String fieldName) {
        // 通过字段，然后进行拼接，获取方法名，fieldName-->bookName->setBookName
        // 所以首先将该字段的首字母大写，然后直接拼接就可以获取方法名
        String updateCaseName = firstToUpdateCase(fieldName);
        // 确保StringBuffer中没有任何数据
        STRING_BUFFER.setLength(0);
        // 拼接set方法
        return STRING_BUFFER.append("set").append(updateCaseName).toString();
    }

    /**
    * @Description: 将String类型字段的首字母转换大写
    * @Param: [field]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    private static String firstToUpdateCase(String field){
        // 截取字符串中第一个字符并转为大写，和后边的字符进行拼接之后返回
        return field.substring(0,1).toUpperCase() + field.substring(1);
    }
}