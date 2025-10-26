package com.bigbasket.controller;

import com.bigbasket.entity.Category;
import com.bigbasket.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class categoryController {

    @Autowired
    private categoryService catService;

    @PostMapping("/category/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = catService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/getCategory/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(catService.getAllCategories());
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(catService.getCategoryById(id));
    }


}

