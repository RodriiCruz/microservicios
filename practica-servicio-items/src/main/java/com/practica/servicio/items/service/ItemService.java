/**
 * 
 */
package com.practica.servicio.items.service;

import java.util.List;

import com.practica.servicio.items.entity.Item;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface ItemService {

    Item findById(Long id, Integer quantity);

    List<Item> findAll();
}
