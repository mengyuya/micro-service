package com.asus.orderservice.config;

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

@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("miya")
                .select()  // 选择哪些路径和api会生成document
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.asus.orderservice.controller"))
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .apiInfo(applicationInfo());//用来创建该Api的基本信息(这些基本信息会展现在文档页面中)
    }

    private ApiInfo applicationInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("订单中心")//大标题
                .description("订单中心api接口可视化管理")//描述/小标题
                .version("0.1")//版本
                .termsOfServiceUrl("")
                .contact(new Contact("miya", "", ""))// 作者
                .license("")//链接显示文字
                .licenseUrl("")//网站链接
                .build();

        return apiInfo;
    }
}