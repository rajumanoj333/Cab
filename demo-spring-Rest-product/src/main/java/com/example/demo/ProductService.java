package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;  // Assume you have a ProductRepository for database interaction

    // Insert a new product
    public Product insert(Product product) {
        return productRepo.save(product);  // Save product to DB
    }

    // Retrieve all products
    public List<Product> getAll() {
        return productRepo.findAll();  // Fetch all products from DB
    }
}
