package com.adev.springexample2.services;

import com.adev.springexample2.model.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    ProductOrder getProductOrderByID(Long id);

    List<ProductOrder> findAllProductOrder();

    void addProductOrder(ProductOrder productOrder);

    void deleteProductOrder(Long id);
}
