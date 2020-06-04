package com.mmz.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-cloud-mapping
 * @description: 并不是让feign支持文件上传得配置
 *      而是修改了feign接收请求得请求头信息（把feign接收请求得请求头信息得默认编码集给改掉）
 *      就是修改了整个springcloud架构接收请求请求头信息的编码集
 *      改为既可以接收文件类型，又可以接收普通的类型
 * @author: Liu Xinpeng
 * @create: 2020-06-03 19:30
 **/
@Configuration
public class FeignMultipartConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;


    /**
    * @Description:
     *      @ConditionalOnBean: 这个注解就是spring提供的修改架构的注解
     *      当某一个bean存在的时候，被这个注解标识的bean就会被加载
    * @Param: []
    * @return: feign.codec.Encoder
    * @Author: Liu Xinpeng
    * @Date: 2020/6/3
    */
    @Bean
    @ConditionalOnBean
    public feign.codec.Encoder springFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

}