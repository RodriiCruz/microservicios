/**
 * 
 */
package com.practica.servicio.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.servicio.items.entity.Item;
import com.practica.servicio.items.entity.Product;
import com.practica.servicio.items.service.ItemService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
@RequestMapping // ("/items") ahora lo asigno mediante las configuraciones del gateway
public class ItemController {

    @Autowired
    private CircuitBreakerFactory cbFactory;

    @Autowired
    @Qualifier("serviceFeign") // cumple la misma función que indicar @Primary en la clase implementada
    private ItemService service;

    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<?> getById(@PathVariable Long id, @PathVariable Integer quantity) {
        return cbFactory.create("items") // id del cb que se va a implementar
                .run(() -> ResponseEntity.ok(service.findById(id, quantity)), e -> alternativeMethod(id, quantity));
        // dentro de este método nos tratamos de comunicar con el microservicio
        // en caso de error, se ejecuta el fallback - Resiliencia programatica
    }

    public ResponseEntity<?> alternativeMethod(Long id, Integer quantity) {
        Product product = Product.builder().id(id).name("Product XYZ").price(500.00).build();
        Item item = Item.builder().quantity(3).product(product).build();

        return ResponseEntity.ok(item);
    }
}
