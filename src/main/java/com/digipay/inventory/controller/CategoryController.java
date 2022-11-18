package com.digipay.inventory.controller;


import com.digipay.inventory.model.category.Category;
import com.digipay.inventory.service.categoryService.CategoryServiceImpl;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
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
    private Category getCategoryById(@PathVariable Long id){
        return categoryService.find(id);
    }

    @DeleteMapping("/delete/{id}")
    private String deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
            return deleteMessage;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @PutMapping("/update/{category}")
    @ResponseBody
    private Category updateCategory(@PathVariable Category category) {
        try {
            categoryService.update(category);
            return category;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        }
    }
}
