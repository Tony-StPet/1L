package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredient")
@Data
@NoArgsConstructor // Конструктор без параметров для JPA
@AllArgsConstructor // Конструктор со всеми параметрами

public class RecipeIngredient implements Serializable {

   private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer recipe_ingredient_id ; // Уникальный идентификатор

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", nullable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity")
    private String quantity; // Количество или единицы измерения

    // Геттеры и сеттеры
    public Integer getId() {
        return recipe_ingredient_id ;
    }

    public void setId(Integer id) {
        this.recipe_ingredient_id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

