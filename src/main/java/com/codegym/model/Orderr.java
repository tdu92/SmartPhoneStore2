package com.codegym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;


@Entity @Data
public class Orderr {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Timestamp time;
    private double total;
    private String customerName;
    private String customerPhone;
}