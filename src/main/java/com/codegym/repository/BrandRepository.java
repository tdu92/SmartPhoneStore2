package com.codegym.repository;

import com.codegym.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    List<Brand> findByBrandNameContaining(String name);
}
