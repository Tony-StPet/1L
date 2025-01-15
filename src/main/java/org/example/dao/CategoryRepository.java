package org.example.dao;

import jakarta.transaction.Transactional;
import org.example.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

  //  @Transactional
    @Query("from Category where categoryId = :id")
    public Category findByCategoryId(@Param("id") Integer id);

  @Query("from Category where name = :category_name")
  public Category findByCategoryName(@Param("category_name") String category_name);
}
