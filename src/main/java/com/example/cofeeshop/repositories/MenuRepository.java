package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
