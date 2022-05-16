package com.example.webstore.repository;

import com.example.webstore.models.ProductModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductModels, Integer> {

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<ProductModels> getAllProducts();
}
