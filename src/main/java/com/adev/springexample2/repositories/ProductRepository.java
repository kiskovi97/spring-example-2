package com.adev.springexample2.repositories;

import com.adev.springexample2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{
}
