package com.digipay.inventory.service;

import com.digipay.inventory.model.category.Category;

public interface BaseServiceCategory<T> {
    void save(Category category);
    void delete(Long id);
    Category getCategoryById(Long id);
    void update(Category category);
}
