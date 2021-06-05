package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double unitPrice;
    private Double profit;
    private Integer servingTime;
    private Instant creationDate;

    @ManyToOne
    private Category category;

    @Builder
    public Food(String name, Double unitPrice, Double profit, Integer servingTime, Category category) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.profit = profit;
        this.servingTime = servingTime;
        this.creationDate = Instant.now();
        this.category = category;
    }

    public void init(){
        this.creationDate = Instant.now();
    }

}
