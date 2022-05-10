package com.example.webstore.repository;

import com.example.webstore.models.CustomerModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModels, Integer> {

}
