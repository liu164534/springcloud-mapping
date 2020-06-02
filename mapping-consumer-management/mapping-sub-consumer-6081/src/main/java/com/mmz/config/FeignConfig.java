package com.mmz.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-06-01 22:47
 **/
@Configuration
@Slf4j
public class FeignConfig implements RequestInterceptor {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String jwtToken = request.getHeader(tokenHeader);
            log.info("jwtToken:" + jwtToken);
            if (StringUtils.isNotBlank(jwtToken)) {
                // header里面添加jwttoken
                requestTemplate.header(tokenHeader, jwtToken);
                log.info("header:" + requestTemplate.headers());
            }
        }
    }
}