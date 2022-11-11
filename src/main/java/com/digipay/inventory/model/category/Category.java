package com.digipay.inventory.model.category;


import com.digipay.inventory.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String name;
    private Long parentId;

}
