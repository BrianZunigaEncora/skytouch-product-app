package com.skytouch.productservice.service;

import com.skytouch.dto.ProductDTO;
import com.skytouch.productservice.entity.Products;
import com.skytouch.productservice.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class ProductListenerTest {
    @InjectMocks
    ProductListener productListener;

    @Mock
    ProductsRepository productsRepository;

    @BeforeEach
    public void init () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProduct_happy_path () {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Brian");
        productDTO.setCost(new BigDecimal("123.4"));
        productDTO.setStoreName("Store");

        productListener.addProduct(productDTO);
    }

    @Test
    public void getProductList_happy_path () {
        Products product = new Products();
        product.setId(1);
        product.setCost(new BigDecimal("123.4"));
        product.setName("Test");
        product.setStoreName("Test");

        when(productsRepository.listProducts())
                .thenReturn(Collections.singletonList(product));

        List<Products>products = productListener.getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        products.forEach(p-> {
                    assertNotNull(p.getId());
                    assertNotNull(p.getCost());
                    assertNotNull(p.getName());
                    assertNotNull(p.getStoreName());});
    }



}
