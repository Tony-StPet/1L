package org.example.dao;

import org.example.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("from Category where categoryId = :id")
    public Category findByCategoryId(@Param("id") Integer id);

}
