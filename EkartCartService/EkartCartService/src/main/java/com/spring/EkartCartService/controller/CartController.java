package com.spring.EkartCartService.controller;

import com.spring.EkartCartService.entity.CartItem;
import com.spring.EkartCartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public String addToCart(@RequestBody CartItem item){
        return cartService.addToCart(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable long userId){
        return cartService.getCart(userId);
    }
}
