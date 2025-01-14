package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name", nullable = false)
    private String name;
    // Конструкторы
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "category")
    private Set<Recipe> recipes; // Связь с рецептами
}
