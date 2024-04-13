package org.example.steampowered.controller;

import java.util.concurrent.ExecutionException;
import java.util.List;

import org.example.steampowered.pojo.Category;
import org.example.steampowered.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public String saveCategory(@RequestBody Category category) throws InterruptedException, ExecutionException {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable String categoryId) {
        try {
            return categoryService.getCategoryById(categoryId);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/categories/all")
    public List<Category> getAllCategories() {
        try {
            return categoryService.getAllCategories();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
