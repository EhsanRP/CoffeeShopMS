package com.example.cofeeshop.repositories;

import com.example.cofeeshop.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
