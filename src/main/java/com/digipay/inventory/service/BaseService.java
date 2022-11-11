package com.digipay.inventory.service;

import com.digipay.inventory.model.category.Category;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    void save(T t);

    void delete(T t);

    void update(T t);

    T find(Long id);

    List<T> findAll();
}
