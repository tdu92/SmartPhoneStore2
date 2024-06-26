package com.codegym.controller;
import com.codegym.model.Product;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productSer;
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> list = productSer.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Product product){
        productSer.save(product);
        String message="Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Product product){
        product.setProductId(id);
        productSer.save(product);
        String message="Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productSer.remove(id);
        String message="Delete success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productSer.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@Param("name")String name){
        List<Product> list = productSer.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
