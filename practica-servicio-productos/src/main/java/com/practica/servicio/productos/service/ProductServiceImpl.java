package com.practica.servicio.productos.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.servicio.commons.entity.Product;
import com.practica.servicio.productos.repository.ProductRepository;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) throws InterruptedException {
		if (id.equals(20L)) {
			// condicion para probar resilience
			throw new IllegalStateException();
		}

		if (id.equals(5L)) {
			// condicion para time out. Llamada lenta
			TimeUnit.SECONDS.sleep(5L);
		}

		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Product save(Product product) {
		product.setCreateAt(new Date());
		return repository.save(product);
	}

	@Override
	@Transactional
	public Product update(Long id, Product product) {
		Product entityDb = repository.findById(id).orElseThrow();
		entityDb.setName(product.getName());
		entityDb.setPrice(product.getPrice());
		return repository.save(entityDb);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
