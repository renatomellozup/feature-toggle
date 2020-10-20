package com.rrodrigues.featuretoggle.cart;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@ConditionalOnProperty(name = "feature.toggles.cart", havingValue = "true")
public class CartController {

    @GetMapping("/message")
    public void showMessage() {
        System.out.println("Cart ativado");
    }
}
