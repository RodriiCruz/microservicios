/**
 * 
 */
package com.practica.servicio.items;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Configuration
public class AppConfig {

    @Bean("restClient")
    @LoadBalanced
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }

    /**
     * ID es el idetificador del circuit breaker. Se podria aplicar una condición
     * .equals para comprobar el nombre que ingresa y realizar diferentes
     * configuraciones según cual cortocircuito se produzca.
     * 
     * slidingWindowSize: tamaño de la ventana deslizante(100 req por defecto)
     * failureRateThreshold: porcentaje de tolerancia a fallos (50 por defecto)
     * waitDurationInOpenState: tiempo que permanece el estado abierto, antes de
     * pasar a semiabierto.
     * permittedNumberOfCallsInHalfOpenState: numero de llamadas durante el estado 
     * semiabierto (10 por defecto).
     */
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defultCustomizer() {
        return factory -> factory.configureDefault(id -> {
            return new Resilience4JConfigBuilder(id)
                    .circuitBreakerConfig(CircuitBreakerConfig.custom()
                            .slidingWindowSize(10)
                            .failureRateThreshold(50)
                            .waitDurationInOpenState(Duration.ofSeconds(10L))
                            .permittedNumberOfCallsInHalfOpenState(5).build())
                    .build();
        });
    }

}
