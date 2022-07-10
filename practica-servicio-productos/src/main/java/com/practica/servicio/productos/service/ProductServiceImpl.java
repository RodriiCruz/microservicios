/**
 * 
 */
package com.practica.servicio.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

}
