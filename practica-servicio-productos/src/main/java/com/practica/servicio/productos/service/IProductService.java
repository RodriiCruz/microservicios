package com.practica.servicio.productos.service;

import java.util.List;

import com.practica.servicio.commons.entity.Product;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface IProductService {

	Product findById(Long id) throws InterruptedException;

	List<Product> findAll();

	Product save(Product product);

	Product update(Long id, Product product);

	void deleteById(Long id);

}
