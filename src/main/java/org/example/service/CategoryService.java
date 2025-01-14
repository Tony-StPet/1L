package org.example.service;
import org.example.model.Category;

public interface CategoryService {

    Iterable<Category> listAll(); // Получить список всех категорий

    void delete(Integer id); // Удалить категорию по ID

    Category add(String name); // Добавить новую категорию

    Category findByCategoryId(Integer id); // Найти категорию по ID

    String getCategoryNameById(Integer id); // Получить название категории по ID

}
