package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
