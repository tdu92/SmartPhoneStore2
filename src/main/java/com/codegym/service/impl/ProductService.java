package com.codegym.service.impl;


import com.codegym.smartphonestore.model.Product;
import com.codegym.smartphonestore.repository.ProductRepository;
import com.codegym.smartphonestore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRep;
    @Override
    public List<Product> findByNameContaining(String name) {
        return productRep.findByProductNameContaining(name);
    }

    @Override
    public List<Product> findAll() {
        return productRep.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRep.findById(id);
        return productOptional.get();
    }

    @Override
    public void save(Product product) {
        productRep.save(product);
    }

    @Override
    public void remove(Long id) {
        productRep.deleteById(id);
    }
}