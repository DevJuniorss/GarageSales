package com.mysuplementstore.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysuplementstore.spring.Models.ShoppingCart;

import java.util.Optional;

public interface CartRepository extends JpaRepository<ShoppingCart, Long> {

    public Optional<ShoppingCart> findByUserId(String user_email);
}
