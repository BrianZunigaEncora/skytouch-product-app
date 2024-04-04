package com.skytouch.productservice.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.skytouch.entity.ProductEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductControllerTests {

    private static ProductController productController;

    @BeforeAll
    public static void init() {
        productController = new ProductController();
    }
    @Test
    public void testExample() {
        ProductEntity productEntity = productController.hello2();
        assertNotNull(productEntity);
    }
}
