package org.example.exo5spring.dao;

import org.example.exo5spring.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {





}
