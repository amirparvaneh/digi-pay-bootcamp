package com.digipay.inventory.controller;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.exception.BusinessException;
import com.digipay.inventory.exception.ValidationException;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.service.productService.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/categories/products")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
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
    @ResponseBody
    private Product getProductByName(@PathVariable("productName") String name) throws BusinessException {
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
    private String deleteProductById(@PathVariable("id") Long productId) throws Exception {
        Boolean result ;
        try {
            result =  productService.deleteById(productId);
            logger.info(String.valueOf(result));
            if (result){
                return deleteMessage;
            }else
                return "nothing to delete";
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
