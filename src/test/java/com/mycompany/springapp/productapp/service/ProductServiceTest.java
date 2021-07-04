package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductCrudRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void test_createProduct_ProductExists()
    {
        ProductModel pm1 = new ProductModel();
        pm1.setPrice(1000.1);
        pm1.setDescription("Garments");

        ProductModel pm2 = new ProductModel();
        pm2.setId(1);
        pm2.setPrice(1000.1);
        pm2.setDescription("Garments");

        Mockito.when(productRepository.findByDescription(pm1.getDescription())).thenReturn(Optional.of(pm1));
        //Mockito.when(productRepository.save(pm1)).thenReturn(pm2);

        Assertions.assertThrows(BusinessException.class,
                ()->{
            productService.createProduct(pm1);
        });
    }

    @Test
    public void test_createProduct_ProductDoesNotExists() throws BusinessException {
        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);

        ProductModel pm1 = new ProductModel();
        pm1.setPrice(1000.1);
        pm1.setDescription("Garments");
        pm1.setCategoryModel(cm);

        ProductModel pm2 = new ProductModel();
        pm2.setCategoryModel(cm);
        pm2.setId(1);
        pm2.setPrice(1000.1);
        pm2.setDescription("Garments");

        Mockito.when(productRepository.findByDescription(pm1.getDescription())).thenReturn(Optional.empty());
        Mockito.when(categoryRepository.findById(pm1.getCategoryModel().getCategoryId())).thenReturn(Optional.of(cm));
        Mockito.when(productRepository.save(pm1)).thenReturn(pm2);

        ProductModel pm = productService.createProduct(pm1);
    }
}
