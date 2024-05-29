package com.codegym.service.impl;

import com.codegym.smartphonestore.model.OrderDetail;
import com.codegym.smartphonestore.repository.OrderDetailRepository;
import com.codegym.smartphonestore.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }
    public OrderDetail findById(Long id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        if (orderDetail.isPresent()) {
            return orderDetail.get(); }
        else return null;

    }
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
    public void remove(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).get();
        orderDetailRepository.save(orderDetail);
    }



}
