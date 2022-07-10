/**
 * 
 */
package com.practica.servicio.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.servicio.productos.entity.Product;
import com.practica.servicio.productos.service.IProductService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @Value("${server.port}")
    private Integer port; // muestra el puerto de la instancia que es llamada

    @GetMapping
    public ResponseEntity<List<Product>> listAll() {

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll().stream().map(producto -> {
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = service.findById(id);
        product.setPort(port);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
