package com.codegym.controller;
import com.codegym.model.Brand;
import com.codegym.model.Product;
import com.codegym.service.IBrandService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private IBrandService brandSer;
    @GetMapping("")
    public ResponseEntity<List<Brand>> getAll(){
        List<Brand> list = brandSer.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Brand brand){
        brandSer.save(brand);
        String message="Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Brand brand){
        brand.setBrandId(id);
        brandSer.save(brand);
        String message="Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        brandSer.remove(id);
        String message="Delete success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id){
        Brand brand = brandSer.findById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Brand>> search(@Param("name")String name){
        List<Brand> list = brandSer.findByBrandNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
