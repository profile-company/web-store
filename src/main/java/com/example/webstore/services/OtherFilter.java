package com.example.webstore.services;

import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class OtherFilter implements StrategyFilter{

    private ProductRepository productRepo;
    private CategoryRepository categoryRepo;

    public void setProductRepo(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public void setCategoryRepo(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Integer> execute(Dictionary data) {

        String price = (String) data.get("price");
        String[] arrayPrice = price.split("-");
        int lessPrice = 0, greaterPrice = 0;
        lessPrice = Integer.parseInt(arrayPrice[0]);
        greaterPrice = Integer.parseInt(arrayPrice[1]);

        List<ProductModels> listProduct = productRepo.getAllProducts();
        List<Integer> x = new ArrayList<>();

        for (ProductModels item:listProduct) {

            int tmp = Integer.parseInt(item.getPrice());
            if (tmp >= lessPrice && tmp <= greaterPrice) {
                x.add(item.getId());
            }
        }


        String nameCategory = (String) data.get("category");
        int idCategory = categoryRepo.getIdCategory(nameCategory);
        List<Integer> y = productRepo.getAllIdProductByCategory(idCategory);

        List<Integer> result = getMatchId(x, y);

        return result;
    }

    private List<Integer> getMatchId(List<Integer> x, List<Integer> y) {

        List<Integer> result = new ArrayList<>();
        for (int i:x) {

            for(int j:y) {
                if (i == j) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
