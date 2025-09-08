package com.spring.EkartProductService.controller;

import com.spring.EkartProductService.entity.Product;
import com.spring.EkartProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/getById/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
}
