package com.productsmanagement.service;

import com.skytouch.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ProductManagementServiceImplTest {

    private ProductManagementService productManagementService;

    @BeforeEach
    void init () {
        productManagementService = new ProductManagementServiceImpl();
    }

    @Test
    void getAllProducts_happy_path () {
        List<ProductDTO> products = productManagementService.getAllProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    void addProduct_happy_path() {
        ProductDTO productDTO = new ProductDTO();
        productDTO = productManagementService.addProduct(productDTO);
        assertNotNull(productDTO);
    }
}
