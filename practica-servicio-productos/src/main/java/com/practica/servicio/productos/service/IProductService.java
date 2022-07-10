/**
 * 
 */
package com.practica.servicio.productos.service;

import java.util.List;

import com.practica.servicio.productos.entity.Product;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface IProductService {

    Product findById(Long id);

    List<Product> findAll();

}
