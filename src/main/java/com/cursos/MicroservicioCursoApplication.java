package com.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers"})
public class MicroservicioCursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioCursoApplication.class, args);
    }

}
