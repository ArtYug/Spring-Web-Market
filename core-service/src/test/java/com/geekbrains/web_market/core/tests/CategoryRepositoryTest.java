package com.geekbrains.web_market.core.tests;

import com.geekbrains.web_market.core.entities.Category;
import com.geekbrains.web_market.core.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAllCategories() {
        Category category = new Category();
        category.setTitle("Electronics");
        category.setProducts(Collections.emptyList());
        entityManager.persist(category);
        entityManager.flush();

        List<Category> categoryList = categoryRepository.findAll();
        Assertions.assertEquals(4, categoryList.size());
        Assertions.assertEquals("Food", categoryList.get(0).getTitle());
    }
}
