package com.example.webstore.repository;

import com.example.webstore.models.OrderItemModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItemModels, Integer> {
}
