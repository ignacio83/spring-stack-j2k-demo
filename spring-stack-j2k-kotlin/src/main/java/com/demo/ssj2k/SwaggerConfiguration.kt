package com.demo.ssj2k

import org.springframework.context.support.beans
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder

fun swaggerBeans() = beans {
    bean<UiConfiguration> {
        UiConfigurationBuilder.builder().build()
    }

    bean<Docket> {
        ApiInfoBuilder()
            .title("Demo")
            .version("1.0")
            .build()
            .let {
                Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.regex("/persons"))
                    .build()
                    .pathMapping("/")
                    .apiInfo(it)
            }
    }
}