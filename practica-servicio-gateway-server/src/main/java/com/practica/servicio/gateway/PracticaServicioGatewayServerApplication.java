package com.practica.servicio.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PracticaServicioGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaServicioGatewayServerApplication.class, args);
    }

}
