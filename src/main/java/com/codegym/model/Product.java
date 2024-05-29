package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Product {
@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
private Long productId;
private String productName;
private double price;
private int quantity;
private String image;
@ManyToOne
private Brand brand;
}
