package com.mmz.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: spring-cloud-mapping
 * @description: 设置Http请求的header
 * @author: Liu Xinpeng
 * @create: 2020-06-01 22:31
 **/
@Component
@Slf4j
public class ActionTrackInterceptor implements ClientHttpRequestInterceptor {
    private static final String JWT_TOKEN_KEY = "jwt-token";

  @Override
  public ClientHttpResponse intercept(
      HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    HttpServletRequest httpServletRequest  = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String jwtToken = httpServletRequest.getHeader(JWT_TOKEN_KEY);
    HttpHeaders headers = request.getHeaders();
    // 加入自定义字段

    log.info("jwtToken:" + jwtToken);
    if (StringUtils.isNotBlank(jwtToken)) {
      // header里面添加jwt-token
      headers.add(JWT_TOKEN_KEY, jwtToken);
      headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
      headers.set(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
    }
    // 保证请求继续被执行
    return execution.execute(request, body);
  }
}