package com.adev.springexample2.repositories;

import com.adev.springexample2.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query(value = "Select p from ProductOrder p where p.person.id = ?1")
    List<ProductOrder> findAllByPersonID(Long id);

    @Query(value = "Select p from ProductOrder p where p.product.id = ?1")
    List<ProductOrder> findAllByProductID(Long id);
}
