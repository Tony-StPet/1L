package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients")
@Data
@NoArgsConstructor // Конструктор без параметров для JPA
@AllArgsConstructor // Конструктор со всеми параметрами

public class RecipeIngredient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // Для уникальности

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private String quantity; // Здесь можете хранить количество или единицы измерения
}

