package com.example.webstore.repository;

import com.example.webstore.models.CategoryModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModels, Integer> {

    @Query(value = "SELECT * FROM category u where u.category_id = ?1",
            nativeQuery = true)
    CategoryModels getDetailCategory(int idCategory);

    @Query(value = "SELECT category_id FROM category u where u.name = ?1",
            nativeQuery = true)
    int getIdCategory(String name);
}
