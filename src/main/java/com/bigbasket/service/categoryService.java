package com.bigbasket.service;

import com.bigbasket.entity.Category;

import java.util.List;

public interface categoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);
}
