package com.example.webstore.services;

import com.example.webstore.dto.DetailProduct;
import com.example.webstore.models.CategoryModels;
import com.example.webstore.models.ProductModels;
import com.example.webstore.repository.CategoryRepository;
import com.example.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The DetailProductConcrete class override ProductFactory to create and return
 * instance of DetailProduct.
 * @author Nguyen Thuan
 * @version 1.00 07 June 2022
 *
 * Modification Logs:
 *      DATE            AUTHOR          DESCRIPTION
 * -------------------------------------------------------------------------
 *
 */
@Service
public class DetailProductConcrete extends ProductFactory{

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Product createProduct(int id) {

        ProductModels productModels = productRepo.getOneProduct(id);
        CategoryModels category = categoryRepo.
                getDetailCategory(productModels.getCategory_id());

        DetailProduct product = new DetailProduct();
        product.setId(id);
        product.setName(productModels.getName());
        product.setCategory(category.getName());
        product.setDescription(category.getDescription());
        product.setPrice(productModels.getPrice());
        product.setSizes(productModels.getSize());
        product.setImages(productModels.getLink());

        return product;
    }
}
