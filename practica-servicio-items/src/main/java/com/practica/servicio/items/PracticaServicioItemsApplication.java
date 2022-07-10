package com.practica.servicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PracticaServicioItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaServicioItemsApplication.class, args);
    }

}
