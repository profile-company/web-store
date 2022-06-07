package com.example.webstore.services;

import com.example.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The ProductFactory class should have some core business logic
 * which needs different product to be created.
 * @author Nguyen Thuan
 * @version 1.00 06-June 2022
 *
 */
@Service
public abstract class ProductFactory {

    @Autowired
    private ProductRepository productRepo;

    /**
     * Subclasses will override this method in order to
     * create specific product objects.
     */
    public abstract Product createProduct(int id);
}
