package com.skytouch.productservice.service;

import com.skytouch.dto.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
    private static ProductService productService;

    @BeforeAll
    public static void init(){
        productService = new ProductServiceImpl();
    }

    @Test
    public void addProduct_happy_path (){
        ProductDTO productDTO = new ProductDTO();
        productService.addProduct(productDTO);
    }

}
