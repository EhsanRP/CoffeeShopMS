package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
