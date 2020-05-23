package com.mmz.config;

import com.mmz.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: spring-cloud-mapping
 * @description: redis集群的配置
 * @author: Liu Xinpeng
 * @create: 2020-05-22 19:17
 **/
//定义为配置类，可替换xml文件
@Configuration 
public class RedisClusterConfig {

    @Autowired
    private RedisClusterProperties redisClusterProperties;

  /**
   * @Description: 注入的redis为java所提供的API(jedisCluster--redis集群客户端，是单例的) @Param: []
   *
   * @return: redis.clients.jedis.JedisCluster @Author: Liu Xinpeng @Date: 2020/5/23
   */
  @Bean
  public JedisCluster getJedisCluster() {
    // 1.获取redisCluter的IP地址以及端口号的信息
    String nodes = redisClusterProperties.getNodes();
    // 2.对获取到的数据进行分割，拆分为IP:端口号的格式
    String[] nodeArr = nodes.split(",");
    // 创建一个用来存放redis集群IP：端口号的Set对象
    Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
    // 3.对分割后的数据进行循环
    for (String node : nodeArr) {
      // 4.再次分割，将IP和端口号分开
      String[] hostPort = node.split(":");
      // 5.创建redis连接所需要的HostAndPort对象
      HostAndPort hostAndPort = new HostAndPort(hostPort[0], Integer.parseInt(hostPort[1]));
      // 6.hostAndPort对象再存入到存放集群IP:端口号的对象中
      hostAndPorts.add(hostAndPort);
    }
    // 7.创建JedisCluster对象(用来连接redisCluster的客户端)
    JedisCluster jedisCluster =
        new JedisCluster(
            hostAndPorts,
            redisClusterProperties.getMaxAttempts(),
            redisClusterProperties.getCommandTimeout());
    // 8.返回JedisCluster客户端对象
    return jedisCluster;
  }
}