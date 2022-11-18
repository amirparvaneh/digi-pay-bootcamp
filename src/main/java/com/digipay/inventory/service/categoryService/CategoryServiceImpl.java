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
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        Optional<Category> updatedCategory = Optional.ofNullable(find(id));
        updatedCategory.get().setName(category.getName());
        updatedCategory.get().setParentId(category.getParentId());
        return updatedCategory;
    }

    @Override
    public Category find(Long id) {
        Category result = new Category();
        result = categoryRepository.findCategoryById(id);
        return result;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
