package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
}
