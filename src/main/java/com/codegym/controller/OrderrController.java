package com.codegym.controller;

import com.codegym.model.Orderr;
import com.codegym.service.IOrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderrController {
    @Autowired
    public IOrderrService orderService;

    // Add đơn hàng sử dụng time LocalDateTime và đưa về định dạng chuẩn
    @GetMapping("")
    public ResponseEntity<List<Orderr>> getAll() {
        List<Orderr> list = orderService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Orderr orderr) {
        orderService.save(orderr);
        String message = "Added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);

    }

}
