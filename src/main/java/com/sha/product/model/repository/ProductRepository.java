package com.sha.product.model.repository;

import com.sha.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    // SELECT * FROM PRODUCTS WHERE PRICE > 3;
    List<Product> findByPriceGreaterThan(Double upperLimit);

    List<Product> findByPriceGreaterThanEqual(Double upperLimit);
}
