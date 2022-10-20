package com.digipay.inventory.model.wareHouse;

import com.digipay.inventory.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class WareHouse extends BaseEntity {

    private String code;
    private String name;
    private Long size;
    private Float capacity;

    public WareHouse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Float getCapacity() {
        return capacity;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }
}
