package com.example.obrestdatajpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Springdoc para la documentación de la API REST
 * HTML: http://localhost:8080/swagger-ui.html
 * JSON: http://localhost:8080/v3/api-docs
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Book API REST",
                version = "1.0",
                description = "Library Api rest docs",
                contact = @Contact(name = "Jose", url = "http://www.google.com", email = "jose@example.com")
        ),
        servers = @Server(url = "http://localhost:8080")
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Library API")
                .pathsToMatch("/**")
                .build();
    }
}

