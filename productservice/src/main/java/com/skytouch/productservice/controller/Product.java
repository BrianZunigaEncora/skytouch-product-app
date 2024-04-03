package com.skytouch.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skytouch.model.ProductModel;

import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class Product {

    @GetMapping("/hello")
    public ProductModel hello2() {
        ProductModel productModel = new ProductModel();
        productModel.setCost(new BigDecimal("123.5"));
        productModel.setName("Brian Zuniga");
        productModel.setStoreName("Skytouch");
        return productModel;
    }

}
