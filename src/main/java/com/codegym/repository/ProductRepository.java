package com.codegym.repository;

import com.codegym.smartphonestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);
    List<Product> findByProductNameContaining(String name);
    List<Product> findByPriceBetween(double from, double to);
    List<Product> findByBrand_BrandId(Long id);
}
