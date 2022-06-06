package com.example.webstore.controllers;

import com.example.webstore.models.CategoryModels;
import com.example.webstore.models.OrderItemModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;
import com.example.webstore.services.AccountSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    ProductRepository productRepo;

    @GetMapping("/detail-product")
    public String productDetail(@RequestParam("id") String id, Model model){

        int idCategory = 0;
        int idProduct = 0;

        AccountSingleton accountSingleton = AccountSingleton.getAccountSingleton();
        System.out.println(accountSingleton.getUserDto().getEmail());

        try {
            idProduct = Integer.parseInt(id);
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        // get id category in table product
        idCategory = productRepo.getIdCategoryProduct(idProduct);

        // get two object product and category
        CategoryModels category = categoryRepo.getDetailCategory(idCategory);
        ProductModels pro = productRepo.getOneProduct(idProduct);

        // transform string of size to list sizes
        String strSizes = pro.getSize();
        List<String> listSize = new ArrayList<String>(Arrays.asList(strSizes.split(",")));

        model.addAttribute("size", listSize);
        model.addAttribute("product", pro);
        model.addAttribute("category", category);

        System.out.println(category.toString());
        System.out.println(pro.toString());

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
