/**
 * 
 */
package com.practica.servicio.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.servicio.productos.entity.Product;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
