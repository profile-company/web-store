package com.example.webstore.repository;

import com.example.webstore.models.OrderModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModels, Integer> {


}
