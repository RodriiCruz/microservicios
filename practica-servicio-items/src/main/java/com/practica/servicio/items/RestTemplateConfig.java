/**
 * 
 */
package com.practica.servicio.items;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Configuration
public class RestTemplateConfig {

    @Bean("restClient")
    @LoadBalanced
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }

}
