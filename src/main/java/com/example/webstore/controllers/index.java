package com.example.webstore.controllers;

import com.example.webstore.dto.ShowProduct;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;
import com.example.webstore.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@Controller
public class index {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ShowProductConcrete factory;

    @GetMapping("/index")
    public String index(Model model){

        String price = "";
        String category = "";

        model.addAttribute("price", price);
        model.addAttribute("category", category);

        return "index";
    }

    @PostMapping("/index")
    public String filterPrice(@ModelAttribute("price") String price,
            @ModelAttribute("category") String category) {

        if (category == null || category.isEmpty()) {

            Dictionary data = new Hashtable();
            data.put("price", price);

            Context context = new Context();
            context.setData(data);
            PriceFilter tmp = new PriceFilter();
            tmp.setProductRepo(productRepo);
            context.setStrategy(tmp);

            List<Integer> listId = context.filter();
            List<ShowProduct> listProduct = new ArrayList<>();
            for (int i:listId) {
                ShowProduct item = (ShowProduct) factory.createProduct(i);
                listProduct.add(item);
                System.out.println(item.toString());
            }
        }
        else if (price == null || price.isEmpty()) {
            Dictionary data = new Hashtable();
            data.put("category", category);

            Context context = new Context();
            context.setData(data);
            CategoryFilter tmp = new CategoryFilter();
            tmp.setCategoryRepo(categoryRepo);
            tmp.setProductRepo(productRepo);
            context.setStrategy(tmp);
            List<Integer> listId = context.filter();
            List<ShowProduct> listProduct = new ArrayList<>();

            for (int i:listId) {
                ShowProduct item = (ShowProduct) factory.createProduct(i);
                listProduct.add(item);
                System.out.println(item.toString());
            }

//            System.out.println(context.filter());
        }

        else {
            Dictionary data = new Hashtable();
            data.put("price", price);
            data.put("category", category);

            Context context = new Context();
            context.setData(data);
            OtherFilter tmp = new OtherFilter();
            tmp.setCategoryRepo(categoryRepo);
            tmp.setProductRepo(productRepo);
            context.setStrategy(tmp);

            List<Integer> listId = context.filter();
            List<ShowProduct> listProduct = new ArrayList<>();
            for (int i:listId) {
                ShowProduct item = (ShowProduct) factory.createProduct(i);
                listProduct.add(item);
                System.out.println(item.toString());
            }

            if (context.filter().isEmpty()) {
                System.out.println("Khong tim thay");
            }
        }

        return "index";
    }

}
