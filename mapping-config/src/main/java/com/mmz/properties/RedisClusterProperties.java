package com.mmz.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-mapping
 * @description: 读取redis_cluster.properties配置文件信息
 *      @Component ：把普通的pojo 实例化到spring容器，泛指组件 当不属于各种归类的时候可以使用
 *      @PropertySource ：加载某个配置文件的属性，指定位置
 *      @ConfigurationProperties ：可以将外部的配置文件(例如application.properties)加载进来
 *      填充对象的对应字段的数据，然后提供给其他bean使用
 * @author: Liu Xinpeng
 * @create: 2020-05-23 15:28
 **/
@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {


    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}