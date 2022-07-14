/**
 * 
 */
package com.practica.servicio.productos.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.servicio.productos.entity.Product;
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
        if (id.equals(10L)) {
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
        return (List<Product>) repository.findAll();
    }

}
