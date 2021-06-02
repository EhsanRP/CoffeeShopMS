package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
