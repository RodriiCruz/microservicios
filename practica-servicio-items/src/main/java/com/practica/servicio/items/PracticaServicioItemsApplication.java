package com.practica.servicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
//Se deshabilita porque requiere DB al incluir dependencia commons que tiene jpa
public class PracticaServicioItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaServicioItemsApplication.class, args);
	}

}
