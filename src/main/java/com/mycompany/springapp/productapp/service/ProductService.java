package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public List<ProductModel> getAllProducts()
    {
        List<ProductModel> productModelList = pr.getAllProducts();
        return productModelList;
    }

    public ProductModel createProduct(ProductModel productModel)
    {
        productModel = pr.createProduct(productModel);
        return productModel;
    }

    public ProductModel deleteProduct(Long id)
    {
        ProductModel productModel = pr.deleteProduct(id);
        return productModel;
    }

    public ProductModel updateProduct(long id, ProductModel productModel)
    {
        ProductModel productModel1 = pr.updateProduct(id,productModel);
        return productModel1;
    }

    public List<ProductModel> searchProductByDescription(String desc)
    {
        List<ProductModel> productsList = null;
        productsList = pr.searchProductByDescription(desc);
        return productsList;
    }

    public List<ProductModel> searchProduct(String desc, double fromPrice, double toPrice)
    {
        List<ProductModel> productsList = null;
        productsList = pr.searchProduct(desc,fromPrice,toPrice);
        return productsList;
    }
}
