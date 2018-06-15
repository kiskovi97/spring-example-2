package com.adev.springexample2.services;

import com.adev.springexample2.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(Long id);

    List<Product> findAllProduct();

    void addProduct(Product product);

    void deleteProduct(Long id);
}
