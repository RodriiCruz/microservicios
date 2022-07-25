package com.practica.servicio.items.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practica.servicio.commons.entity.Product;
import com.practica.servicio.items.entity.Item;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restClient;

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());

		Product product = restClient.getForObject("http://servicio-productos/{id}", Product.class, pathVariables);

		return new Item(product, quantity);
	}

	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restClient.getForObject("http://servicio-productos", Product[].class));

		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Product save(Product product) {
		HttpEntity<Product> requestBody = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = restClient.exchange("http://servicio-productos", HttpMethod.POST,
				requestBody, Product.class);
		return response.getBody();
	}

	@Override
	public Product update(Long id, Product product) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());

		HttpEntity<Product> requestBody = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = restClient.exchange("http://servicio-productos/{id}", HttpMethod.PUT,
				requestBody, Product.class, pathVariable);
		return response.getBody();
	}

	@Override
	public void deleteById(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		restClient.delete("http://servicio-productos/{id}", pathVariable);

	}

}
