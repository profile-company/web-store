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

    @Query(value = "SELECT * FROM product u where u.product_id = ?1",
        nativeQuery = true)
    ProductModels getOneProduct(int id);

    @Query(value = "SELECT category_id FROM product u where u.product_id = ?1",
            nativeQuery = true)
    int getIdCategoryProduct(int id);

    @Query(value = "SELECT product_id FROM product",
            nativeQuery = true)
    List<Integer> getAllIdProduct();

    @Query(value = "SELECT product_id FROM product u where u.category_id = ?1",
            nativeQuery = true)
    List<Integer> getAllIdProductByCategory(int idCategory);
}
