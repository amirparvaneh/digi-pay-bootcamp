package com.digipay.inventory.controller;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.exception.BusinessException;
import com.digipay.inventory.exception.ValidationException;
import com.digipay.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    private ProductDto save(@RequestBody ProductDto productDto) throws BusinessException {
        if (Objects.nonNull(productDto)){
            throw new ValidationException();
        }
        productService.save(productDto);
        return productDto;
    }
}
