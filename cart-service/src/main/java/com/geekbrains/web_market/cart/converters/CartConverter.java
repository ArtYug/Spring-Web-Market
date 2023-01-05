package com.geekbrains.web_market.cart.converters;

import com.geekbrains.web_market.api.cart.CartDto;
import com.geekbrains.web_market.api.cart.CartItemDto;
import com.geekbrains.web_market.api.core.ProductDto;
import com.geekbrains.web_market.cart.models.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartConverter {
    public CartDto modelToDto(Cart cart) {
        List<CartItemDto> cartItemDtoList = cart.getItems().stream().map(it ->
                new CartItemDto(it.getProductId(), it.getProductTitle(), it.getQuantity(), it.getPricePerProduct(),
                        it.getPrice())
        ).toList();
        return new CartDto(cartItemDtoList, cart.getTotalPrice());
    }
}