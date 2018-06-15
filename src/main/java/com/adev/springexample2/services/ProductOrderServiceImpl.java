package com.adev.springexample2.services;

import com.adev.springexample2.model.ProductOrder;
import com.adev.springexample2.repositories.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrder getProductOrderByID(Long id) {
        return productOrderRepository.getOne(id);
    }

    @Override
    public List<ProductOrder> findAllProductOrder() {
        return productOrderRepository.findAll();
    }

    @Override
    public void addProductOrder(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    @Override
    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }
}
