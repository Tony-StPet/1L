package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.IngredientRepository;
import org.example.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IngredientServiceImpl {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Iterable<Ingredient> listAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient add(String name) {
        return ingredientRepository.save(new Ingredient(name));
    }

    @Override
    public Ingredient findByIngredientId(Integer id) {
        return ingredientRepository.findByIngredientId(id);
    }

    @Override
    public String getIngredientNameById(Integer id) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(id);
        return ingredient != null ? ingredient.getName() : null; // Возвращаем имя или null, если ингредиент не найден
    }
}
