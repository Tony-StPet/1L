package org.example.service;

import org.example.model.Ingredient;

public interface IngredientService {
    Iterable<Ingredient> listAll(); // Получить список всех ингредиентов

    void delete(Integer id); // Удалить ингредиент по ID

    Ingredient add(String name); // Добавить новый ингредиент

    Ingredient findByIngredientId(Integer id); // Найти ингредиент по ID

    // Метод для получения названия ингредиента по ID
    String getIngredientNameById(Integer id);
}
