package com.mentoriatiago.integraSellers.configurations;

import org.ff4j.core.FeatureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  private static final String BASE_PACKAGE =
      "com.mentoriatiago.integraSellers.gateways.inputs.controllers";

  @Autowired
  private FeatureStore featureStore;

  @Bean
  public Docket internal() {

    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(getApiInfo());

  }

  private ApiInfo getApiInfo() {

    return new ApiInfoBuilder()
        .title("Integra Sellers.")
        .description("App de integração de sellers.")
        .version("1")
        .build();

  }
}
