package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
