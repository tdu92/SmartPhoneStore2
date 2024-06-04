package com.codegym.service.impl;


import com.codegym.model.Brand;
import com.codegym.repository.BrandRepository;
import com.codegym.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRep;

    @Override
    public List<Brand> findByBrandNameContaining(String name) {
        return brandRep.findByBrandNameContaining(name);
    }

    @Override
    public List<Brand> findAll() {
        return brandRep.findAll();
    }

    @Override
    public Brand findById(Long id) {
        Optional<Brand> brandOptional = brandRep.findById(id);
        return brandOptional.get();
    }

    @Override
    public void save(Brand brand) {
brandRep.save(brand);
    }

    @Override
    public void remove(Long id) {
brandRep.deleteById(id);
    }
}