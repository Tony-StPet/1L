package org.example.service;

import org.example.model.Recipe;

public interface RecipeService {

    Iterable<Recipe> listAll(); // Получить список всех рецептов

    Recipe findById(Integer id); // Найти рецепт по ID

    void delete(Integer id); // Удалить рецепт по ID

    Recipe add(Recipe recipe); // Добавить новый рецепт
}
