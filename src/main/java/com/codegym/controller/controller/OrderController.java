package com.codegym.controller.controller;

import com.codegym.model.Order;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    public IOrderService orderService;

    // Add đơn hàng sử dụng time LocalDateTime và đưa về định dạng chuẩn
    @GetMapping("")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> list = orderService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<String> add(@RequestBody Order order) {
        orderService.save(order);
        String message = "Added successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);

    }



}
