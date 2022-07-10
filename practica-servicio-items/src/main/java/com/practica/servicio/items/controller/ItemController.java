/**
 * 
 */
package com.practica.servicio.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.servicio.items.service.ItemService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign") // cumple la misma función que indicar @Primary en la clase implementada
    private ItemService service;

    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<?> getById(@PathVariable Long id, @PathVariable Integer quantity) {
        return ResponseEntity.ok(service.findById(id, quantity));
    }
}
