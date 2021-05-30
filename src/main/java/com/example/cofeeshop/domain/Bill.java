package com.example.cofeeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant creationDate;
    private Instant completionDate;
    private Double totalPrice;
    private Boolean isApproved;

    @OneToMany(mappedBy = "bill")
    private Set<Item> orders = new HashSet<>();

    @Builder
    public Bill(Double totalPrice, Set<Item> orders) {
        this.creationDate = Instant.now();
        this.completionDate = Instant.now();
        this.isApproved = false;

        this.totalPrice = Objects.requireNonNullElse(totalPrice, 0D);

        if (orders != null) {
            addAllOrders(orders);
            calculateTotalPrice();

        }
    }

    private void calculateTotalPrice() {
        if (orders != null) {
            orders.forEach(order -> totalPrice += order.getPrice());
        }
    }

    public Bill addOrder(Item order) {
        order.setBill(this);
        this.orders.add(order);
        calculateTotalPrice();
        return this;
    }

    public void addAllOrders(Set<Item> orders) {
        orders.forEach(order -> {
            order.setBill(this);
            this.orders.add(order);
        });
        calculateTotalPrice();
    }
}
