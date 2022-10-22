package com.digipay.inventory.service;

import com.digipay.inventory.checking.Checking;
import com.digipay.inventory.checking.CheckingImpl;
import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MajorService {

    private Checking checking;


    public final void register(ProductDto productDto){
        checking = new CheckingImpl();
        checking.checkQuality();
        checking.checkPosition();
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        save(product);
    }

    public abstract void save(Product product);
}
