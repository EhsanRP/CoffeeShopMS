package com.example.cofeeshop.services;

import com.example.cofeeshop.repositories.CategoryRepository;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Value
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public void removeCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
