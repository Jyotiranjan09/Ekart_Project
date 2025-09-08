package com.spring.EkartOrderService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    private int quantity;
    private double total;
}
