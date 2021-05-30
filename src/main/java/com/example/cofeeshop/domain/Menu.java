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
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant creationDate;
    private Instant modificationDate;

    @OneToMany(mappedBy = "menu")
    private Set<Category> categories = new HashSet<>();

    @Builder
    public Menu(Set<Category> categories) {
        this.creationDate = Instant.now();

        editModificationDate();
        if (categories != null) {
            addAllCategories(categories);
        }
    }

    public Menu addCategory(Category category) {
        category.setMenu(this);
        this.categories.add(category);
        editModificationDate();
        return this;
    }

    public void addAllCategories(Set<Category> categories) {
        categories.forEach(food -> {
            food.setMenu(this);
            this.categories.add(food);
        });
        editModificationDate();
    }

    private void editModificationDate() {
        modificationDate = Instant.now();
    }
}