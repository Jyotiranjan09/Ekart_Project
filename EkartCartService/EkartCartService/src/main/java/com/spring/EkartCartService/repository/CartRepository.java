package com.spring.EkartCartService.repository;

import com.spring.EkartCartService.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByUserId(long userId);
}
