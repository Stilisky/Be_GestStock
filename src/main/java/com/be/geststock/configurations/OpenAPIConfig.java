package com.be.geststock.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI userMicroservicesApi(){
        return new OpenAPI()
                .info(new Info().title("Be GestStock")
                        .description("Application de gestion des stock")
                        .version("1.0"));
    }
}
