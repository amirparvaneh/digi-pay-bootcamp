package com.digipay.inventory.controller;


import com.digipay.inventory.model.category.Category;
import com.digipay.inventory.service.categoryService.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    private CategoryController(CategoryServiceImpl categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping()
    private void addNewCategory(@RequestBody Category category){
        categoryService.save(category);
    }

    @GetMapping("")
    private List<Category> getAllCategories(){
        return categoryService.findAll();
    }


}
