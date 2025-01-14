package org.example.service;

import org.example.dao.RecipeIngredientRepository;
import org.example.model.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService{

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public Iterable<RecipeIngredient> listAll() {
        // Возвращает все связи между рецептами и ингредиентами
        return recipeIngredientRepository.findAll();
    }

    @Override
    public RecipeIngredient findById(Integer id) {
        // Поиск связи по ID
        return recipeIngredientRepository.findById(id).orElse(null); // Возвращает null, если не найден
    }

    @Override
    public void delete(Integer id) {
        // Удаление связи по ID
        recipeIngredientRepository.deleteById(id);
    }

    @Override
    public RecipeIngredient add(RecipeIngredient recipeIngredient) {
        // Добавление новой связи
        return recipeIngredientRepository.save(recipeIngredient);
    }
}
