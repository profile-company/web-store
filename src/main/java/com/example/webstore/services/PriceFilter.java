package com.example.webstore.services;

import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.ProductRepository;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;


public class PriceFilter implements StrategyFilter{

    ProductRepository productRepo;

    public void setProductRepo(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Integer> execute(Dictionary data) {

        String price = (String) data.get("price");
        String[] arrayPrice = price.split("-");
        int lessPrice = 0, greaterPrice = 0;
        lessPrice = Integer.parseInt(arrayPrice[0]);
        greaterPrice = Integer.parseInt(arrayPrice[1]);

        List<ProductModels> listProduct = productRepo.getAllProducts();
        List<Integer> listId = new ArrayList<>();
        for (ProductModels item:listProduct) {

            int tmp = Integer.parseInt(item.getPrice());
            if (tmp >= lessPrice && tmp <= greaterPrice) {
                listId.add(item.getId());
            }
        }

        return listId;
    }
}
