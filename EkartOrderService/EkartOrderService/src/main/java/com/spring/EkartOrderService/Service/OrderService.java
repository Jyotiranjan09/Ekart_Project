package com.spring.EkartOrderService.Service;

import com.spring.EkartOrderService.dto.OrderRequest;
import com.spring.EkartOrderService.dto.Product;
import com.spring.EkartOrderService.entity.Order;
import com.spring.EkartOrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;









    public Order placeOrder(OrderRequest req){
        String url="http://EKARTPRODUCTSERVICE/products/getById/"+req.getProductId();
        ResponseEntity<Product> resp =restTemplate.getForEntity(url, Product.class);

        Product product=resp.getBody();
        if(product==null){
            return null;
        }
        Order order=new Order();
        order.setProductId(product.getId());
        order.setQuantity(req.getQuantity());
        order.setTotal(product.getPrice()* req.getQuantity());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
