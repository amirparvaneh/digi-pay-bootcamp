package com.digipay.inventory.service.productService;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Product findByName(String name);
    void deleteById(Long id);
}
