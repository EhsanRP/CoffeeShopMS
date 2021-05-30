package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;
    private Integer quantity;

    @ManyToOne
    private Food food;

    @ManyToOne
    private Bill bill;

    @Builder
    public Item(Integer quantity, Food food, Double price, Bill bill) {
        this.quantity = quantity;
        this.food = food;
        this.bill = bill;

        if (food != null || quantity != null)
            calculatePrice();
    }

    private void calculatePrice() {
        this.price = quantity * food.getUnitPrice();
    }
}
