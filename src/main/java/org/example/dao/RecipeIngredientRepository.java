package org.example.dao;

import org.example.model.RecipeIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer>{

    @Query("from RecipeIngredient where id = :id")
    public RecipeIngredient findByRecipeIngredientId(@Param("id") Integer id);
}
