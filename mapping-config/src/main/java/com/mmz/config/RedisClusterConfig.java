package com.mmz.config;

import com.mmz.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-cloud-mapping
 * @description: redis集群的配置
 * @author: Liu Xinpeng
 * @create: 2020-05-22 19:17
 **/
@Configuration //定义为配置类，可替换xml文件
public class RedisClusterConfig {

    @Autowired
    private RedisClusterProperties redisClusterProperties;
}