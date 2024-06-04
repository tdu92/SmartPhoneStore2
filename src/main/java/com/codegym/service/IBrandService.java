package com.codegym.service;

import com.codegym.model.Brand
        ;

import java.util.List;

public interface IBrandService extends IGenerateService<Brand> {
    List<Brand> findByBrandNameContaining(String name);
}
