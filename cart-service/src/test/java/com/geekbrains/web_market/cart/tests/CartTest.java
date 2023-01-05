package com.geekbrains.web_market.cart.tests;

import com.geekbrains.web_market.api.core.ProductDto;
import com.geekbrains.web_market.cart.integrations.ProductsServiceIntegration;
import com.geekbrains.web_market.cart.services.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class CartTest {
    public static String suffix = "result test";
    @Autowired
    private CartService cartService;

    @MockBean
    private  ProductsServiceIntegration productsServiceIntegration;

    @BeforeEach
    public void init() {
        cartService.clearCart("test_cart");
    }

    @Test
    public void addToCartTest() {
        ProductDto product = new ProductDto();
        product.setId(1L);
        product.setTitle("Milk");
        product.setPrice(BigDecimal.valueOf(100.00));


        Mockito.doReturn(product).when(productsServiceIntegration).findById(1L);
        cartService.addToCart("test_cart", 1L);
        cartService.addToCart("test_cart", 1L);
        cartService.addToCart("test_cart", 1L);

        Mockito.verify(productsServiceIntegration, Mockito.times(3)).findById(ArgumentMatchers.eq(1L));
        Assertions.assertEquals(
                1, cartService.getCurrentCart("test_cart").getItems().size());

        cartService.clearCart("test_cart");
        Assertions.assertEquals(0,cartService.getCurrentCart("test_cart").getItems().size());
        System.out.println(cartService.getCartUuidFromSuffix(suffix));
    }
}
