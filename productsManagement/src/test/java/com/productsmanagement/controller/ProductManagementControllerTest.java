package com.productsmanagement.controller;


import com.productsmanagement.service.ProductManagementService;
import com.skytouch.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductManagementControllerTest {
    @InjectMocks
    ProductManagementController productManagementController;

    @Mock
    ProductManagementService productManagementService;

    @Test
    public void addProduct_happy_path() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        ProductDTO mockResponse = new ProductDTO();
//        mockResponse.setName("Brian Test");
//        mockResponse.setCost(new BigDecimal("123.45"));
//        mockResponse.setStoreName("Store test");
//
//        when(productManagementService.addProduct(any(ProductDTO.class))).thenReturn(mockResponse);
//
//        ProductDTO response = productManagementController.addProduct(mockResponse);
//
//        assertNotNull(response);
//        assertEquals(response.getName(), mockResponse.getName());

    }

    @Test
    public void getAllProducts_Happy_Path() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        ProductDTO mockResponse = new ProductDTO();
//        mockResponse.setName("Brian Test");
//        mockResponse.setCost(new BigDecimal("123.45"));
//        mockResponse.setStoreName("Store test");
//
//        List<ProductDTO> mockListResponse = Arrays.asList(mockResponse);
//        when(productManagementService.getAllProducts()).thenReturn(mockListResponse);
//
//        String response = productManagementController.getProducts();
//
//        assertNotNull(response);
//        assertFalse(response.isEmpty());

    }

}
