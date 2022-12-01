package com.digipay.inventory.controller;


import com.digipay.inventory.model.category.Category;
import com.digipay.inventory.service.categoryService.CategoryServiceImpl;
import com.sun.jdi.LongValue;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;
    private static final String savedMessage = "category have been saved";
    private static final String deleteMessage = "category have been deleted";

    @Autowired
    private CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    private String addNewCategory(@RequestBody Category category) {
        categoryService.save(category);
        return savedMessage + "\n" + category.getName();
    }

    @GetMapping()
    private List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    private Category getCategoryById(@PathVariable("id") String inputId) {
        Long id = Long.parseLong(inputId);
        return categoryService.find(id);
    }

    @DeleteMapping(value = "/{id}")
    private String deleteCategory(@PathVariable("id") Long id) {
        try {
            categoryService.deleteById(id);
            return deleteMessage;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    private Optional<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }
}
