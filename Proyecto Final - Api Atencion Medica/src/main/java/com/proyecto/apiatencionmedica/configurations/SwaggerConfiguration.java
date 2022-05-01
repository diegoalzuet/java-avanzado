package com.proyecto.apiatencionmedica.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springdoc.core.Constants.ALL_PATTERN;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiAtencionMedica() {
        return new OpenAPI()
                .info(new Info().title("Proyecto Final Java Avanzado")
                        .description("Proyecto Final del Curso de Java Avanzado de CoderHouse")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                        .contact(new Contact()
                        		.name("Diego Alzuet")
                        		.email("diegoalzuet@gmail.com")
                        		.url("https://github.com/diegoalzuet/java-avanzado")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio Diego Alzuet")
                        .url("https://github.com/diegoalzuet/java-avanzado"));
    }

    @Bean
    public GroupedOpenApi apiAtencionMedicaGroup() {
        return GroupedOpenApi.builder().group("appmedica")
                .addOpenApiCustomiser(openApi -> this.apiAtencionMedica())
                .packagesToScan("com.proyecto.apiatencionmedica.controllers")
                .build();
    }

    @Bean
    public GroupedOpenApi actuatorApi(OpenApiCustomiser actuatorOpenApiCustomiser,
                                      OperationCustomizer actuatorCustomizer,
                                      WebEndpointProperties endpointProperties,
                                      @Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder()
                .group("Actuator")
                .pathsToMatch(endpointProperties.getBasePath()+ ALL_PATTERN)
                .addOpenApiCustomiser(actuatorOpenApiCustomiser)
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
                .addOperationCustomizer(actuatorCustomizer)
                .pathsToExclude("/health/*")
                .build();
    }
}
