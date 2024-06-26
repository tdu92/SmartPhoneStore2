package com.codegym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Brand {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long brandId;
    private String brandName;
}
