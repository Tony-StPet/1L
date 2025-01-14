package org.example.model;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor // Конструктор без параметров для JPA
@AllArgsConstructor // Конструктор со всеми параметрами

public class Recipe implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer recipeId;

    @Column(name = "title", nullable = false, length = 70)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    @ManyToOne

    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category; // Предполагается, что у вас есть класс Category для категории
}
