package org.example.service;
import org.example.model.Category;
import org.example.model.Recipe;

public interface CategoryService {

    Iterable<Category> listAll(); // Получить список всех категорий

    void delete(Integer id); // Удалить категорию по ID

    Category add(String category_name); // Добавить новую категорию

    Category findByCategoryId(Integer id); // Найти категорию по ID

    Category findByName(String category_name);

    String getCategoryNameById(Integer id); // Получить название категории по ID

}
