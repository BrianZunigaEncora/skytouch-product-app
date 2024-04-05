package com.skytouch.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skytouch.entity.ProductEntity;

import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class ProductController {

    @GetMapping("/hello")
    public ProductEntity hello2() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCost(new BigDecimal("123.5"));
        productEntity.setName("Brian Zuniga");
        productEntity.setStoreName("Skytouch");
        return productEntity;
    }

}
