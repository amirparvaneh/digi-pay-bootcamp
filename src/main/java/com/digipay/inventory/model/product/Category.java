package com.digipay.inventory.model.product;

import com.digipay.inventory.model.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
//decorator design pattern

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String code;
    private String name;
}
