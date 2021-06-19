package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.TagModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagModel, Long> {
}
