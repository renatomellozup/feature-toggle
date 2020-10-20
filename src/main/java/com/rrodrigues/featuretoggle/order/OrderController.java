package com.rrodrigues.featuretoggle.order;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@ConditionalOnProperty(name = "feature.toggles.order", havingValue = "true")
public class OrderController {

    @GetMapping("/message")
    public void showMessage() {
        System.out.println("Order ativado");
    }
}
