package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService ps;

    @GetMapping(value = "/products")
    public ResponseEntity<Iterable<ProductModel>> getAllProducts()
    {
        Iterable<ProductModel> list = ps.getAllProducts();

        //ResponseEntity<List<ProductModel>> responseEntity = new ResponseEntity<>(displayAllProducts, HttpStatus.OK);
        //return responseEntity;
        return (new ResponseEntity<Iterable<ProductModel>>(list, HttpStatus.OK));
    }

    @PostMapping(path = "/products", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel)
    {
        System.out.println("create product");

        productModel = ps.createProduct(productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel, HttpStatus.CREATED);

        return res;
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id)
    {
        ProductModel productModel = ps.deleteProduct(id);
        ResponseEntity<?> res = null;
        if(null != productModel)
        {
            res = new ResponseEntity<ProductModel>(productModel, HttpStatus.OK);
        }
        else
        {
            res = new ResponseEntity<String>("product not found", HttpStatus.NOT_FOUND);
        }
        return res;
    }

    @PutMapping(value="/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") long id,
                                                      @RequestBody ProductModel productModel)
    {
        ProductModel productModel1 = ps.updateProduct(id,productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel1, HttpStatus.OK);

        return res;
    }

    @PutMapping(value="/products/update/{id}")
    public ResponseEntity<ProductModel> updateProduct1(@PathVariable("id") long id,
                                                      @RequestBody ProductModel productModel)
    {
        ProductModel productModel1 = ps.updateProduct1(id,productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel1, HttpStatus.OK);

        return res;
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<ProductModel>> searchProduct(
            @RequestParam("desc") String desc,
            @RequestParam("fromPrice") double fromPrice,
            @RequestParam("toPrice") double toPrice)
    {
        List<ProductModel> productsList = ps.searchProduct(desc,fromPrice,toPrice);
        ResponseEntity res = new ResponseEntity(productsList, HttpStatus.OK);

        return res;
    }

    @GetMapping("/products/searchByDescription")
    public ResponseEntity<List<ProductModel>> searchProductByDescription(@RequestParam("desc") String desc)
    {
        List<ProductModel> productsList = ps.searchProductByDescription(desc);
        ResponseEntity res = new ResponseEntity(productsList, HttpStatus.OK);

        return res;
    }
}
