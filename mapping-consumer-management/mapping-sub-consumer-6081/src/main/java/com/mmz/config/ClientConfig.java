package com.mmz.config;

import com.mmz.interceptor.ActionTrackInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-06-01 22:42
 **/

@Configuration
public class ClientConfig {

    @Autowired
    ActionTrackInterceptor actionTrackInterceptor;


    // TODO
    /**
     * 这里就是创建一个负载均衡的RestTemplate Bean
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // 把自定义的ClientHttpRequestInterceptor添加到RestTemplate，可添加多个
        restTemplate.setInterceptors(Collections.<ClientHttpRequestInterceptor>singletonList(actionTrackInterceptor));
        return restTemplate;
    }

}