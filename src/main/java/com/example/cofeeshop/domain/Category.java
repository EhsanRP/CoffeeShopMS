package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant creationDate;
    private String name;

    @ManyToOne
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private Set<Food> foods = new HashSet<>();

    @Builder
    public Category(Set<Food> foods, String name, Menu menu) {

        this.name = name;
        this.menu = menu;

        this.creationDate = Instant.now();
        if (foods != null) {
            addAllFoods(foods);
        }

    }

    public Category addّFood(Food food) {
        food.setCategory(this);
        this.foods.add(food);
        return this;
    }

    public void addAllFoods(Set<Food> foods) {
        foods.forEach(food -> {
            food.setCategory(this);
            this.foods.add(food);
        });
    }
}
