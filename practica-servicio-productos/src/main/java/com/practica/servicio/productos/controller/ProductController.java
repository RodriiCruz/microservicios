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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.servicio.productos.entity.Product;
import com.practica.servicio.productos.service.IProductService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
@RequestMapping // ("/products") ahora lo asigno mediante las configuraciones del gateway
public class ProductController {

	@Autowired
	private IProductService service;

	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@GetMapping
	public ResponseEntity<List<Product>> listAll() {

		return ResponseEntity.status(HttpStatus.OK).body(service.findAll().stream().map(product -> {
			product.setInstanceId(instanceId);
			return product;
		}).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) throws InterruptedException {
		Product product = service.findById(id);
		product.setInstanceId(instanceId);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product response = service.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
		Product response = service.update(id, product);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
