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

    private String name;
    private Instant creationDate;
    private Instant modificationDate;

    @OneToMany(mappedBy = "menu")
    private Set<Category> categories = new HashSet<>();

    public Menu(String name) {
        this.name = name;
    }

    @Builder
    public Menu(Set<Category> categories, String name) {
        init();
        this.name = name;
        if (categories != null) {
            addAllCategories(categories);
        }

    }

    public void setName(String name) {
        this.name = name;
        editModificationDate();
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
        editModificationDate();
    }

    public void init() {
        this.creationDate = Instant.now();
        this.modificationDate = Instant.now();
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