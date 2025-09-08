package com.spring.EkartOrderService.controller;

import com.spring.EkartOrderService.Service.OrderService;
import com.spring.EkartOrderService.dto.OrderRequest;
import com.spring.EkartOrderService.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest req){
        return  orderService.placeOrder(req);
    }

    @GetMapping
    public List<Order> allOrders(){
        return  orderService.getAllOrders();
    }
}
