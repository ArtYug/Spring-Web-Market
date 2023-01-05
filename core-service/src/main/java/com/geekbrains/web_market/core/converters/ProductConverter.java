package com.geekbrains.web_market.core.converters;

import com.geekbrains.web_market.api.core.ProductDto;
import com.geekbrains.web_market.core.entities.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}