package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @PostMapping(path = "/categories")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel)
    {
        categoryModel = cs.createCategory(categoryModel);
        ResponseEntity<CategoryModel> res = new ResponseEntity<>(categoryModel, HttpStatus.CREATED);

        return res;
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<Iterable<CategoryModel>> getAllCategories()
    {
        Iterable<CategoryModel> categoryModels = cs.getAllCategories();
        ResponseEntity<Iterable<CategoryModel>> res = new ResponseEntity<Iterable<CategoryModel>>(categoryModels, HttpStatus.OK);
        return res;
    }
}
