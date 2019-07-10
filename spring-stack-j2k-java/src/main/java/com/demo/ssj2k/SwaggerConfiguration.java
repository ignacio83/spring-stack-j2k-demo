package com.demo.ssj2k;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket documentation() {
    final ApiInfo apiInfo = new ApiInfoBuilder().title("Demo").version("1.0").build();
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(regex("/persons"))
        .build()
        .pathMapping("/")
        .apiInfo(apiInfo);
  }

  @Bean
  public UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder().build();
  }
}
