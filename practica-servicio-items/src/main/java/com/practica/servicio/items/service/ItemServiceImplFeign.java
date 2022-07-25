package com.practica.servicio.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.servicio.commons.entity.Product;
import com.practica.servicio.items.clients.ProductRestClient;
import com.practica.servicio.items.entity.Item;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Service("serviceFeign")
public class ItemServiceImplFeign implements ItemService {

	@Autowired
	private ProductRestClient restClient;

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(restClient.getById(id).getBody(), quantity);
	}

	@Override
	public List<Item> findAll() {
		List<Product> listProducts = restClient.listAll().getBody();

		return listProducts.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Product save(Product product) {
		return restClient.save(product).getBody();
	}

	@Override
	public Product update(Long id, Product product) {
		return restClient.update(id, product).getBody();
	}

	@Override
	public void deleteById(Long id) {
		restClient.deleteById(id);
	}

}
