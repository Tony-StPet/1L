package org.example.service;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.CategoryRepository;
import org.example.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category add(String category_name) {

        return categoryRepository.save(new Category(category_name));
    }

    @Override
    public Category findByCategoryId(Integer id) {
        return categoryRepository.findByCategoryId(id);
    }

    @Override
    public Category findByName(String category_name) {
        return categoryRepository.findByCategoryName(category_name);}

    @Override
    public String getCategoryNameById(Integer id) {
        Category category = categoryRepository.findByCategoryId(id);
        return category != null ? category.getName() : "вне категорий"; // Возвращаем имя или null, если категория не найдена
    }
}
