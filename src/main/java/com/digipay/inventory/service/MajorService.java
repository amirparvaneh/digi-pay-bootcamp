package com.digipay.inventory.service;

import com.digipay.inventory.checking.Checking;
import com.digipay.inventory.checking.CheckingImpl;
import com.digipay.inventory.model.product.Product;

public abstract class MajorService {

    private Checking checking;


    public final void register(Product product){
        checking = new CheckingImpl();
        checking.checkQuality();
        checking.checkPosition();
        save(product);
    }

    public abstract void save(Product product);
}
