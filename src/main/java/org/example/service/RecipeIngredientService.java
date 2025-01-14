package org.example.service;

import org.example.model.RecipeIngredient;

public interface RecipeIngredientService {

    Iterable<RecipeIngredient> listAll(); // Получить список всех связей между рецептами и ингредиентами

    RecipeIngredient findById(Integer id); // Найти связь по ID

    void delete(Integer id); // Удалить связь по ID

    RecipeIngredient add(RecipeIngredient recipeIngredient); // Добавить новую связь
}
