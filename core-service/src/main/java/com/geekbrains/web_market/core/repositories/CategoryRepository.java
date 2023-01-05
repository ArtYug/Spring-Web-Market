package com.geekbrains.web_market.core.repositories;

import com.geekbrains.web_market.core.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String title);
}
