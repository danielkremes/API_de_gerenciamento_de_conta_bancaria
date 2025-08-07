package com.drk.API_de_gerenciamento_de_conta_bancaria.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Minha API REST")
                        .version("1.0.0")
                        .description("Documentação da API REST com Swagger e Springdoc"));
    }
}
