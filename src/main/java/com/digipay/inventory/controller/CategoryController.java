package com.digipay.inventory.controller;


import com.digipay.inventory.service.categoryService.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    private CategoryController(CategoryServiceImpl categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping()
    private void addNewCategory(){

    }
}
