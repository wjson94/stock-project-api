package com.wjproject.stockproject.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI testOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Stock Project API 문서")
                        .description("테스트 API")
                        .version("1.0"));
    }
}
