package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {

    @Autowired
    private CategoryRepository cr;

    public CategoryModel createCategory(CategoryModel categoryModel)
    {
        categoryModel = cr.save(categoryModel);// when cr.save() then return a category model which has id inside it
        return categoryModel;
    }
    public Iterable<CategoryModel> getAllCategories()
    {
        Iterable<CategoryModel> categoryModels = cr.findAll();
        return categoryModels;
    }
}
