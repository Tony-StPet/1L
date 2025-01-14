package org.example.service;

import org.example.dao.RecipeRepository;
import org.example.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> listAll() {
        // Возвращает все рецепты из базы данных
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Integer id) {
        // Поиск рецепта по ID
        return recipeRepository.findById(id).orElse(null); // Возвращает null, если не найден
    }

    @Override
    public void delete(Integer id) {
        // Удаление рецепта по ID
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe add(Recipe recipe) {
        // Добавление нового рецепта
        return recipeRepository.save(recipe);
    }
}
