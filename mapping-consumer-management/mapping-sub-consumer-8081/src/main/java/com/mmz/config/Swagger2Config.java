package com.mmz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.mmz.staticstatus.RequestURLProperties.PACKAGE_CONTROLLER_URL;

/**
 * @program: spring-cloud-mapping
 * @description: 生成规范的开发文档API
 * @author: Liu Xinpeng
 * @create: 2020-05-21 17:18
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
    * @Description: 创建了docker的bean
    * @Param: []
    * @return: springfox.documentation.spring.web.plugins.Docket 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/22
    */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 选择swagger具体生效的接口是什么？(service, controller, mapper)
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();

    }
    /**
    * @Description: API的基本信息，构建了整个项目的一些描述信息
    * @Param: []
    * @return: springfox.documentation.service.ApiInfo 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测绘管理系统")
                .description("mmz的测绘管理系统")
                .contact(new Contact("Liu Xinpeng", "http://www.mmz.com", "liu164534@Gmail.com"))
                .version("1.0")
                .build();
    }

}