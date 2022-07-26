package com.practica.servicio.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PracticaServicioUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaServicioUsersApplication.class, args);
	}

}
