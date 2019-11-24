package com.huiali.controller;

import com.huiali.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategory")
    public Object getUser(int id){
        return  categoryService.getCategory(id);
    }

}
