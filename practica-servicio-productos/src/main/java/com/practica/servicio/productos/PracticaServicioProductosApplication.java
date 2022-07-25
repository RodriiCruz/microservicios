package com.practica.servicio.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.practica.servicio.commons.entity" })
public class PracticaServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaServicioProductosApplication.class, args);
	}

}
