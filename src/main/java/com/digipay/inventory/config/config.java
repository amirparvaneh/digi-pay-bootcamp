package com.digipay.inventory.config;

import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class config {

    @Bean
    public ProductService productService(){
        return new ProductService() {
            @Override
            public void save(ProductDto productDto) {
            }
        };
    }
}
