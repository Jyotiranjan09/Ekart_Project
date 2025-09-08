package com.spring.EkartCartService.client;

import com.spring.EkartCartService.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="EKARTPRODUCTSERVICE")
public interface ProductClient {
    @GetMapping("/products/getById/{id}")
    Product getProduct(@PathVariable long id);
}
