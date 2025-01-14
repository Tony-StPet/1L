package org.example.dao;

import org.example.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    @Query("from Recipe where recipeId = :id")
    public Recipe findByRecipeId(@Param("id") Integer id);
}
