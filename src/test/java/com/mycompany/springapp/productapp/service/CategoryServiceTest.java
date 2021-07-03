package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks //creates a singleton dummy object for category service
    private CategoryService categoryService;

    @Mock //creates a dummy singleton object of category repository and also injects it inside category service
    private CategoryRepository categoryRepository;

    @Test
    public void test_createCategory()
    {
        CategoryModel categoryModel1 = new CategoryModel();
        categoryModel1.setCategoryName("Food");

        CategoryModel categoryModel3 = new CategoryModel();
        categoryModel3.setCategoryId(1L);
        categoryModel3.setCategoryName("Food");

        //when cr.save() then return a category model which has id inside it
        Mockito.when(categoryRepository.save(categoryModel1)).thenReturn(categoryModel3);

        CategoryModel categoryModel2 = categoryService.createCategory(categoryModel1);
        Assertions.assertNotNull(categoryModel2.getCategoryId(),"Test failed because new category should have an Id");
    }

    @Test
    public void test_getAllCategories_With_0_Size()
    {
        List<CategoryModel> categories = (List<CategoryModel>) categoryService.getAllCategories();
        Assertions.assertEquals(categories.size(), 0);
    }

    @Test
    public void test_getAllCategories_With_Non_Zero_Size()
    {
        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);
        cm.setCategoryName("Food");

        List<CategoryModel> listOfCat = new ArrayList<>();
        listOfCat.add(cm);

        Mockito.when(categoryRepository.findAll()).thenReturn(listOfCat);

        List<CategoryModel> categories = (List<CategoryModel>) categoryService.getAllCategories();
        Assertions.assertEquals(categories.size(), 1);
    }
}
