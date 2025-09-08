package com.spring.EkartProductService.service;

import com.spring.EkartProductService.entity.Product;
import com.spring.EkartProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(long id,Product product){
        if(productRepository.findById(id).isPresent()){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public Product deleteProduct(long id){
        if(productRepository.findById(id).isPresent()){
            Product product=productRepository.findById(id).get();
            productRepository.deleteById(id);
            return product;
        }
        else{
            return null;
        }
    }
    public Product getProductById(long id){
        if(productRepository.findById(id).isPresent()){
            Product product=productRepository.findById(id).get();
            return product;
        }
        else{
            return null;
        }
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
