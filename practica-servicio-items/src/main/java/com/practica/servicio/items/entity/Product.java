/**
 * 
 */
package com.practica.servicio.items.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date createAt;

}
