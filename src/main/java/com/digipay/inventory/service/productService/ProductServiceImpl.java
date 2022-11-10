package com.digipay.inventory.service.productService;

import com.digipay.inventory.checking.CheckingImpl;
import com.digipay.inventory.model.product.Product;
import com.digipay.inventory.repository.ProductRepository;
import com.digipay.inventory.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductServiceImpl extends MajorService implements ProductService {

    private ProductRepository productRepository;

    private CheckingImpl checking;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CheckingImpl checking) {
        this.productRepository = productRepository;
        this.checking = checking;
    }

    @Override
    public void save(Product product) {
        checking.checkQuality();
        checking.checkPosition();
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public Boolean deleteById(Long id) throws Exception {
        Product product = new Product();
        try {
            product = productRepository.getProductById(id);
            if (Objects.nonNull(product)) {
                productRepository.deleteById(id);
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


//    Qualifier

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
