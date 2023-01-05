package com.geekbrains.web_market.api.core;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Product model")
public class ProductDto {
    @Schema(description = "Product id", required = true, example = "1")
    private Long id;
    @Schema(description = "The product's name", required = true, maxLength = 255, minLength = 3, example = "candy")
    private String title;
    @Schema(description = "Product price", required = true, example = "120")
    private BigDecimal price;

    @Schema(description = "Product category", required = true, example = "Food")
    private String categoryTitle;

    public ProductDto() {
    }

    public ProductDto(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    public ProductDto(Long id, String title, BigDecimal price, String categoryTitle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
