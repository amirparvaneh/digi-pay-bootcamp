package com.digipay.inventory.service.categoryService;

import com.digipay.inventory.model.category.Category;
import com.digipay.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public Category find(Long id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categories = categoryRepository.findAll();
        return categories;
    }
}
