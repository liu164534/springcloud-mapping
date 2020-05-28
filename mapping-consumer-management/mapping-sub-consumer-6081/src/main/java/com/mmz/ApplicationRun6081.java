package com.mmz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: spring-cloud-mapping
 * @description: consumer启动类
 * @author: Liu Xinpeng
 * @create: 2020-05-28 16:24
 **/
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationRun6081 {
  public static void main(String[] args) {
      SpringApplication.run(ApplicationRun6081.class,args);
  }
}