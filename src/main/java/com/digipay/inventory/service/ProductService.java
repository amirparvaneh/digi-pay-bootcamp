package com.digipay.inventory.service;

import com.digipay.inventory.dto.ProductDto;
import org.springframework.stereotype.Component;


public interface ProductService {
    void save(ProductDto productDto);
}
