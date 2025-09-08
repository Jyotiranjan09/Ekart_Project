package com.spring.EkartOrderService.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private long productId;
    private int quantity;
}
