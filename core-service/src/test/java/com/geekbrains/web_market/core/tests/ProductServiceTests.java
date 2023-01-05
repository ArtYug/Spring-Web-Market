package com.geekbrains.web_market.core.tests;

import com.geekbrains.web_market.api.core.ProductDto;
import com.geekbrains.web_market.core.entities.Category;
import com.geekbrains.web_market.core.repositories.ProductsRepository;
import com.geekbrains.web_market.core.services.CategoryService;
import com.geekbrains.web_market.core.services.ProductsService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@SpringBootTest(classes = ProductsService.class)
public class ProductServiceTests {
    @Autowired
    ProductsService productsService;
    @MockBean
    private ProductsRepository productsRepository;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void createNewProductTest() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Food");
        category.setProducts(Collections.emptyList());
        Mockito.doReturn(Optional.of(category))
                .when(categoryService)
                .findByTitle("Food");
        ProductDto productDto = new ProductDto(null, "Orange", BigDecimal.valueOf(100.0), "Food");
        productsService.createNewProduct(productDto);
        Mockito.verify(productsRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
