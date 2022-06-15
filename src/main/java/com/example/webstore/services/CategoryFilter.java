package com.example.webstore.services;

import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class CategoryFilter implements StrategyFilter{

    private CategoryRepository categoryRepo;
    private ProductRepository productRepo;

    public void setCategoryRepo(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void setProductRepo(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Integer> execute(Dictionary data) {

        String nameCategory = (String) data.get("category");
        int idCategory = categoryRepo.getIdCategory(nameCategory);
        List<Integer> listId = productRepo.getAllIdProductByCategory(idCategory);

        return listId;
    }
}
