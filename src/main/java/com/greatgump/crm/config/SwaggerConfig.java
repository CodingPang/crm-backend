package com.greatgump.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/12 12:57
 * @since 1.0
 */
@Component
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("crm管理系统")// 组名
        .apiInfo(apiInfo())// api信息的描述
        .enable(true)//开始swagger
        .select() // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
        .apis(RequestHandlerSelectors.basePackage("com.greatgump.crm.controller")) // 配置扫描哪些接口
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("crm管理系统swagger版项目接口文档")
        .description("crm管理系统swagger版项目接口测试")
        .version("1.0.0")
        .contact(new Contact("codingpang", "https://www.greatgump.com", "邮箱"))
        .termsOfServiceUrl("")
        .license("")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
        .build();
  }
}
