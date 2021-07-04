package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
    List<CategoryModel> findByCategoryName(String categoryName);
}
