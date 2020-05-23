package com.mmz.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-mapping
 * @description: 读取ftp.properties配置文件
 * @author: Liu Xinpeng
 * @create: 2020-05-23 16:18
 **/
@Component
@PropertySource("classpath:properties/ftp.properties")
@ConfigurationProperties(prefix = "spring.ftp")
@Data
public class FtpProperties {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String basePath;
    private String httpPath;
}