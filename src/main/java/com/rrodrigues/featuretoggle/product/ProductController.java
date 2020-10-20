package com.rrodrigues.featuretoggle.product;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@ConditionalOnProperty(name = "feature.toggles.product", havingValue = "true")
public class ProductController {

    @GetMapping("/message")
    public void showMessage() {
        System.out.println("Product ativado");
    }
}
