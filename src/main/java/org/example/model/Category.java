package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")

@Data

public class Category implements Serializable {

    public Category(String category_name) {

        this.category_name = category_name;
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name", nullable = false)
    private String category_name;
    // Конструкторы
    public Category() {}

    // Геттеры и сеттеры
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return category_name;
    }

    public void setName(String category_name) {
        this.category_name = category_name;
    }
   @OneToMany(mappedBy = "category" , fetch = FetchType.EAGER) //! 2
    //! 1
   private Set<Recipe> recipes = new HashSet<>(); // Связь с рецептами

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + category_name + '\''+

                ", recipes=" + recipes + '}';
    }
}
