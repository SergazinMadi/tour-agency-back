package com.example.touragencyback.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Touragency Back")
                        .version("1.0")
                        .description("Api document and testing")
                        .license(new License()
                                        .name("Aldous2")
                                        .url("https://www.cia.gov/"))
                        );
    }
}
