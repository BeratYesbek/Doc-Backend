package com.doc.doc_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
=======

@SpringBootApplication
>>>>>>> 30349c71e9b5ff0b36891f0a5a7454a7b7c6cd82
public class DocBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocBackendApplication.class, args);
    }

<<<<<<< HEAD
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }
=======
>>>>>>> 30349c71e9b5ff0b36891f0a5a7454a7b7c6cd82
}
