package com.example.webstore.controllers;

import com.example.webstore.dto.DetailProduct;
import com.example.webstore.models.OrderItemModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;

import com.example.webstore.services.DetailProductConcrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class Product {

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    DetailProductConcrete factory;

    @Autowired
    ProductRepository productRepo;

    @GetMapping("/detail-product")
    public String productDetail(@RequestParam("id") String id, Model model){

        int idProduct = 0;

        try {
            idProduct = Integer.parseInt(id);
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        DetailProduct product = (DetailProduct) factory
                .createProduct(idProduct);


        // transform string of size to list sizes
        String sizes = product.getSizes();
        List<String> listSize = new ArrayList<String>(Arrays
                .asList(sizes.split(",")));

        model.addAttribute("size", listSize);
        model.addAttribute("product", product);

        return "DetailProduct";
    }

    @PostMapping("/cart")
    public String cart(@RequestParam("selected") String size,
                       @RequestParam("idProduct") String id,
                       Model model) {

        ProductModels item = new ProductModels();
        item = productRepo.getOneProduct(Integer.parseInt(id));
        OrderItemModels orderItemModels =  new OrderItemModels();
        System.out.println(orderItemModels.toString());

        model.addAttribute("item", item);
        model.addAttribute("size", size);
        model.addAttribute("order", orderItemModels);

        return "cart";
    }
}
