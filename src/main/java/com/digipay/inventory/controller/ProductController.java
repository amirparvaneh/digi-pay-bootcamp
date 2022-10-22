package com.digipay.inventory.controller;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.exception.BusinessException;
import com.digipay.inventory.exception.ValidationException;
import com.digipay.inventory.service.productService.ProductService;
import com.digipay.inventory.service.productService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping()
    private ProductDto saveNewProduct(@RequestBody ProductDto productDto) throws BusinessException {
        if (Objects.nonNull(productDto)){
            throw new ValidationException();
        }
        productService.register(productDto);
        return productDto;
    }
}
