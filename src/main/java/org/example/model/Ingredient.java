package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ingredient")
@Data

@AllArgsConstructor // Конструктор со всеми параметрами
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredient_Id;

    @Column(name = "name", nullable = false)
    private String name;

    // Конструктор
    public Ingredient() {}

    public Ingredient(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры
    public int getIngredientId() {
        return ingredient_Id;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredient_Id = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients; // Связь с рецептурными ингредиентами
}
