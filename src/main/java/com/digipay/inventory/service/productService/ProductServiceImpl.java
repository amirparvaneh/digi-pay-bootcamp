package com.digipay.inventory.service.productService;

import com.digipay.inventory.checking.CheckingImpl;
import com.digipay.inventory.dto.ProductDto;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.repository.ProductRepository;
import com.digipay.inventory.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl extends MajorService implements ProductService {

    private ProductRepository productRepository;

    private CheckingImpl checking;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {

    }

    Qualifier

//
//    @Transactional
//    @Override
//    public void saveNewProduct(ProductDto productDto) {
//        register(productDto);
//        Product product = new Product();
//        product.setName(productDto.getName());
//        product.setPrice(productDto.getPrice());
//        productRepository.save(product);
//    }

//    @Transactional
//    @Override
//    public void register(ProductDto productDto) {
//        checking = new CheckingImpl();
//        checking.checkQuality();
//        checking.checkPosition();
//        Product product = new Product();
//        product.setName(productDto.getName());
//        product.setPrice(productDto.getPrice());
//        productRepository.save(product);
//
//    }
}
