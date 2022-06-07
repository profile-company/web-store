package com.example.webstore.services;

import com.example.webstore.dto.ShowProduct;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowProductConcrete extends ProductFactory{

    @Autowired
    private ProductRepository productRepo;

//    @Autowired
//    private CategoryRepository categoryRepo;


    @Override
    public Product createProduct(int id) {

        ProductModels productModels = productRepo
                .getOneProduct(id);

        if (productModels == null) {
            throw new ArithmeticException("Product not found!");
        }

        ShowProduct product = new ShowProduct();
        product.setId(id);
        product.setName(productModels.getName());
        product.setPrice(productModels.getPrice());
        product.setImg(productModels.getLink());

        return product;
    }
}
