package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;
    private int orderQuantity;
    @ManyToOne
    private Order orderId;
    @ManyToOne
    private Product productId;
}
