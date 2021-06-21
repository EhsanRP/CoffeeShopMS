package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();

    public void addCategory(Category category) {
        category.setMenu(this);
        this.categories.add(category);
    }

    public void addAllCategories(List<Category> categories) {
        categories.forEach(food -> {
            food.setMenu(this);
            this.categories.add(food);
        });
    }

}