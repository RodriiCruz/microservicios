/**
 * 
 */
package com.practica.servicio.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practica.servicio.items.entity.Product;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@FeignClient(name = "servicio-productos")
public interface ProductRestClient {

    @GetMapping
    public ResponseEntity<List<Product>> listAll();

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id);

}
