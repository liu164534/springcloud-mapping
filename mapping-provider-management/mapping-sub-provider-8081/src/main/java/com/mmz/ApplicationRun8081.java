package com.mmz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: spring-cloud-mapping
 * @description:
 *      可以使用 @SpringCloudApplication 来代替 @SpringBootApplication
 * @author: Liu Xinpeng
 * @create: 2020-05-23 22:52
 **/
// 将redis的默认加载的配置类给排除掉
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@MapperScan("comm.mmz.mapper")
// 能够让注册中心发现，扫描到该服务 可以是其他的注册中心（eg:ZK）
@EnableDiscoveryClient
// 熔断器
@EnableCircuitBreaker
public class ApplicationRun8081 {
  public static void main(String[] args) {
      SpringApplication.run(ApplicationRun8081.class, args);
  }
}