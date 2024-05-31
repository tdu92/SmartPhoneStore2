package com.codegym.service.impl;

import com.codegym.model.Orderr;
import com.codegym.repository.OrderrRepository;
import com.codegym.service.IOrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderrService implements IOrderrService {
    @Autowired
    private OrderrRepository orderRepository;
    public List<Orderr> findAll() {
        return orderRepository.findAll();
    }
    public Orderr findById(Long id) {
        Optional<Orderr> order = orderRepository.findById(id);
        if (order.isPresent()) {
        return order.get(); }
        else return null;

    }
    public void save(Orderr orderr) {
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
        Orderr orderr = orderRepository.findById(id).get();
        orderRepository.save(orderr);
    }

}
