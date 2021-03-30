package com.invest.honduras.config;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("PARAMETER API")
                .description("Parameter Management REST API")
                 .license("Apache 2.0")
                 .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0").build();
    }
}
