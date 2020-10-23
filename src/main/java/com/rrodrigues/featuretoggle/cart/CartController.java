package com.rrodrigues.featuretoggle.cart;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cart")
@ConditionalOnProperty(name = "feature.toggles.cart", havingValue = "true")
public class CartController {

    private final boolean cardsEnabled;

    public CartController(@Value("${feature.toggles.carts}") boolean cardsEnabled) {
        this.cardsEnabled = cardsEnabled;
    }

    @GetMapping("/message")
    public void showMessage() {
        System.out.println("Cart ativado");
    }

    @SneakyThrows
    @GetMapping("/list")
    public List<Cart> carts() {
        if (!cardsEnabled)
            throw new Exception("feature disabled");

        List<Cart> carts = Arrays.asList(new Cart(1l, "Renato"), new Cart(2l, "Leandro"));

        return carts;
    }
}
