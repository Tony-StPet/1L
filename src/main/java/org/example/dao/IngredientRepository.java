package org.example.dao;

import org.example.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    @Query("from Ingredient where ingredientId = :id")
    public Ingredient findByIngredientId(@Param("id") Integer id);
}
