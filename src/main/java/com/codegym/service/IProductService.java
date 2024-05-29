package com.codegym.service;

import com.codegym.smartphonestore.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> findByNameContaining(String name);
}
