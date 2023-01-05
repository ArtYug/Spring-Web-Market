package com.geekbrains.web_market.core.services;

import com.geekbrains.web_market.core.entities.Category;
import com.geekbrains.web_market.core.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
