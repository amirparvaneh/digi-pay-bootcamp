package com.digipay.inventory.model.category;


import com.digipay.inventory.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @JsonProperty("name")
    private String name;
    @JsonProperty("parentId")
    private Long parentId;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
