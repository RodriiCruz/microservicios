package com.practica.servicio.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PracticaServicioProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaServicioProductosApplication.class, args);
    }

}
