/**
 * 
 */
package com.practica.servicio.items.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    private Product product;
    private Integer quantity;

    public Double getTotal() {
        return product.getPrice() * quantity.doubleValue();
    }
}
