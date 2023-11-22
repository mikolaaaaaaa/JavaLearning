package com.mikola.java_learn_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI javaLearnOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("JavaLearning-API")
                                .description("Simple API for JavaLearning application")
                                .version("1.0"));
    }
}