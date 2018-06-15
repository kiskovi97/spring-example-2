package com.adev.springexample2.services;

import com.adev.springexample2.model.Product;
import com.adev.springexample2.model.ProductOrder;
import com.adev.springexample2.repositories.ProductOrderRepository;
import com.adev.springexample2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private ProductOrderRepository productOrderRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public Product getProductByID(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        List<ProductOrder> productOrder = productOrderRepository.findAllByProductID(id);
        if (productOrder.isEmpty())
            productRepository.deleteById(id);
    }
}
