package com.example.webstore.controllers;

import com.example.webstore.models.CategoryModels;
import com.example.webstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Product {

    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping("/detail-product")
    public String productDetail(@RequestParam("id") String id){

        int idCategory = 0;

        try {
            idCategory = Integer.parseInt(id);
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        CategoryModels category = categoryRepo.getDetailCategory(idCategory);

        System.out.println(category.toString());
        System.out.println(id);

        return "DetailProduct";
    }
}
