package com.digipay.inventory.controller;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.exception.BusinessException;
import com.digipay.inventory.exception.ValidationException;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.service.productService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("/categories/products")
public class ProductController {

    private Logger logger;
    private final static String deleteMessage = "successful deleted";
    private final static String updatedMessage = "successful updated";
    private final static String addMessage = "successful saved";

    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @PostMapping
    private String saveNewProduct(@RequestBody Product product) throws BusinessException {
        try {
            if (Objects.isNull(product)) {
                throw new ValidationException();
            }
            productService.register(product);
            return addMessage;
        } catch (RuntimeException e) {
            throw new BusinessException(e.getCause());
        }
    }

    @GetMapping
    private List<Product> getAllProduct() throws Exception {
        try {
            return productService.findAllProduct();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @GetMapping("/{productName}")
    private Product getProductByName(@PathVariable String name) throws BusinessException {
        try {
            return productService.findByName(name);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/update/product")
    private String updateProduct(@RequestBody Product product) throws BusinessException {
        try {
            productService.save(product);
            return deleteMessage;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private String deleteProductById(@PathVariable Long productId) throws BusinessException {
        try {
            productService.deleteById(productId);
            logger.info(deleteMessage);
            return updatedMessage;
        } catch (Exception e) {
            throw new BusinessException(e.getCause());
        }

    }

}
