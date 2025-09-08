package com.spring.EkartCartService.service;
import com.spring.EkartCartService.client.ProductClient;
import com.spring.EkartCartService.entity.CartItem;
import com.spring.EkartCartService.entity.Product;
import com.spring.EkartCartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductClient productClient;

    //Add product to cart
    public String addToCart(CartItem item){
        Product product =productClient.getProduct(item.getProductId());
        if(product==null){
            return "Product not found";
        }
        item.setPrice(product.getPrice());
        cartRepository.save(item);
        return "Product added to cart";
    }

    //Get all items of a user cart
    public List<CartItem> getCart(Long userId){
        return cartRepository.findByUserId(userId);
    }
}
