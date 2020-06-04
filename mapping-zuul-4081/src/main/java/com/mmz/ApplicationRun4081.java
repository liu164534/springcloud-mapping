package com.mmz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: spring-cloud-mapping
 * @description: zuul启动类
 * @author: Liu Xinpeng
 * @create: 2020-06-04 10:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = {"com.mmz"})
public class ApplicationRun4081 {
  public static void main(String[] args) {
      SpringApplication.run(ApplicationRun4081.class, args);
  }
}