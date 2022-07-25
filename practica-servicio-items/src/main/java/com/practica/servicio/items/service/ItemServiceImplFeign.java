package com.practica.servicio.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.servicio.items.clients.ProductRestClient;
import com.practica.servicio.items.entity.Item;
import com.practica.servicio.items.entity.Product;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
