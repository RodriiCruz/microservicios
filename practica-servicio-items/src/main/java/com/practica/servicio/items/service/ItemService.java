package com.practica.servicio.items.service;

import java.util.List;

import com.practica.servicio.commons.entity.Product;
import com.practica.servicio.items.entity.Item;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface ItemService {

	Item findById(Long id, Integer quantity);

	List<Item> findAll();

	Product save(Product product);

	Product update(Long id, Product product);

	void deleteById(Long id);
}
