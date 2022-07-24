/**
 * 
 */
package com.practica.servicio.items.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.servicio.items.entity.Item;
import com.practica.servicio.items.entity.Product;
import com.practica.servicio.items.service.ItemService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
@RequestMapping // ("/items") ahora lo asigno mediante las configuraciones del gateway
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign") // cumple la misma función que indicar @Primary en la clase implementada
	private ItemService service;

	@Autowired
	private Environment env;

	@GetMapping
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@CircuitBreaker(name = "items", fallbackMethod = "alternativeMethod")
	@TimeLimiter(name = "items")
	@GetMapping("/{id}/{quantity}")
	public CompletableFuture<ResponseEntity<?>> getById(@PathVariable Long id, @PathVariable Integer quantity) {
		return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(service.findById(id, quantity)));
	}

	public CompletableFuture<ResponseEntity<?>> alternativeMethod(Long id, Integer quantity, Throwable e) {
		Product product = Product.builder().id(id).name("Product XYZ").price(500.00).build();
		Item item = Item.builder().quantity(3).product(product).build();

		return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(item));
	}

	@GetMapping("/profiles")
	public ResponseEntity<?> getProfile(@Value("${test.msg}") String text) {
		Map<String, String> response = new HashMap<>();
		response.put("Text", text);

		if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			response.put("Author", env.getProperty("author.name"));
		}

		return ResponseEntity.ok(response);
	}
}
