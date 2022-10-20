package com.digipay.inventory.repository;

import com.digipay.inventory.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}