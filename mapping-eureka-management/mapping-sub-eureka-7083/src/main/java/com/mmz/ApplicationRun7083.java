package com.mmz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-20 15:36
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7083 {
  public static void main(String[] args) {
      SpringApplication.run(ApplicationRun7083.class, args);
  }
}