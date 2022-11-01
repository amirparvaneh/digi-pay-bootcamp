package com.digipay.inventory.model.consumer;

import com.digipay.inventory.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "external")
public class External extends BaseEntity {

    @JsonProperty("name")
    private String name;

    public External() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
