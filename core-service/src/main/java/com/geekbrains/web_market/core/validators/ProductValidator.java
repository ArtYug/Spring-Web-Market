package com.geekbrains.web_market.core.validators;

import com.geekbrains.web_market.api.core.ProductDto;
import com.geekbrains.web_market.core.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
       public void  validate(ProductDto productDto){
           List<String>errors = new ArrayList<>();
           if (productDto.getPrice().compareTo(BigDecimal.ONE) < 0){
               errors.add("Product price cannot be less than 1");
           }
           if (productDto.getTitle().isBlank()){
               errors.add("Product name cannot be empty");
           }
           if (!errors.isEmpty()){
               throw new ValidationException(errors);
           }
       }
}
