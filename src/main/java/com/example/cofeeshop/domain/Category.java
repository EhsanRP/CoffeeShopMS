package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private Set<Food> foods = new HashSet<>();

    public void addFood(Food food) {
        food.setCategory(this);
        this.foods.add(food);
    }

    public void addAllFoods(Set<Food> foods) {
        foods.forEach(food -> {
            food.setCategory(this);
            this.foods.add(food);
        });
    }

}
