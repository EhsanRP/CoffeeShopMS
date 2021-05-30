package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
