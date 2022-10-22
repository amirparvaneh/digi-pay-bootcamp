package com.digipay.inventory.service.externalservice;

import com.digipay.inventory.checking.CheckingImpl;
import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.repository.ProductRepository;
import com.digipay.inventory.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ExternalServiceImpl extends MajorService implements ExternalService {

    private ProductRepository productRepository;

    private final CheckingImpl checking;

    @Autowired
    public ExternalServiceImpl(ProductRepository productRepository, CheckingImpl checking) {
        this.productRepository = productRepository;
        this.checking = checking;
    }


//    @Transactional
//    @Override
//    public void register(ProductDto productDto) {
//        checking.checkQuality();
//        checking.checkPosition();
//        Product product = new Product();
//        product.setName(productDto.getName());
//        product.setPrice(productDto.getPrice());
//        productRepository.save(product);
//    }
}
