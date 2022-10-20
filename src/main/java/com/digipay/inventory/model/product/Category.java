package com.digipay.inventory.model.product;

import com.digipay.inventory.model.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
public class Category extends BaseEntity {

    private String code;
    private String name;
}
