package com.practica.servicio.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.servicio.commons.entity.Product;

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

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product);

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product);

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable Long id);
}
