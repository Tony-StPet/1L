package org.example.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "recipe")
//@Data

public class Recipe implements Serializable{
   private static final long serialVersionUID = 1L;

    public Recipe(String title, String description, String instructions, Category category) {

        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.category = category;
    }
    public Recipe() {    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipe_Id;

    @Column(name = "title", nullable = false, length = 70)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    @ManyToOne

    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category; // Предполагается, что у вас есть класс Category для категории

    public Integer getRecipeId() {
        return recipe_Id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipe_Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category=" + category.getName() +
                '}';
    }
}
