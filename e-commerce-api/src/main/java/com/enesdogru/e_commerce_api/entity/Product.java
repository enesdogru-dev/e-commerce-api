package com.enesdogru.e_commerce_api.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name",nullable = false,length = 100)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "stock",nullable = false)
    private Integer stock;


}
