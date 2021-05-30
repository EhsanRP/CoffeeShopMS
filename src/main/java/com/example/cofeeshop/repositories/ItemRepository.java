package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
