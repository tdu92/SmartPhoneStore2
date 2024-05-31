package com.codegym.service.impl;

import com.codegym.model.Order;
import com.codegym.repository.OrderRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
        return order.get(); }
        else return null;

    }
    public void save(Order order) {
//        List<Order> orders = order.getCustomer();
//        if (!orders.isEmpty()) {
//            Set<Order> managedOrders = new HashSet<>();
//            for (Order order : orders) {
//                if (order.getIdOrder() !=null) {
//                    Optional<Order> o = orderRepository.findById(order.getIdOrder());
//                    managedOrders.add(o.get());
//                }
//            }
//            order.setCustomerId(managedOrders);
//        }
//        orderRepository.save(order);
    }
    public void remove(Long id) {
        Order order = orderRepository.findById(id).get();
        orderRepository.save(order);
    }

}
