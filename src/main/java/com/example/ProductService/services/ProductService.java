package com.example.ProductService.services;

import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long id);

    public List<Product> getAllProducts();

}
