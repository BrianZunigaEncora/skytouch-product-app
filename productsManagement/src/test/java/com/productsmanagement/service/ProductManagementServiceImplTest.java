package com.productsmanagement.service;

import com.productsmanagement.exception.ProductException;
import com.productsmanagement.util.ProductErrors;
import com.productsmanagement.util.Utils;
import com.skytouch.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class ProductManagementServiceImplTest {

    @InjectMocks
    private ProductManagementServiceImpl productManagementService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void getAllProducts_happy_path () {
        when(rabbitTemplate.convertSendAndReceive(anyString(), any(Object.class)))
                .thenReturn(Utils.getMockProducts());

        List<ProductDTO> products = productManagementService.getAllProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    void getAllProducts_serviceNotAvailable() {
        when(rabbitTemplate.convertSendAndReceive(anyString(), any(Object.class)))
                .thenReturn(null);
        ProductException productException = assertThrows(ProductException.class, () -> {
            List<ProductDTO> products = productManagementService.getAllProducts();
        });

        assertNotNull(productException.getErrorMessage());
        assertEquals(productException.getErrorMessage(), ProductErrors.MICROSERVICE_NOT_AVAILABLE);
    }

    @Test
    void getAllProducts_notExpectedType() {
        when(rabbitTemplate.convertSendAndReceive(anyString(), any(Object.class)))
                .thenReturn("String");
        ProductException productException = assertThrows(ProductException.class, () -> {
            List<ProductDTO> products = productManagementService.getAllProducts();
        });

        assertNotNull(productException.getErrorMessage());
        assertEquals(productException.getErrorMessage(), ProductErrors.UNEXPECTED_TYPE);
    }

    @Test
    void addProduct_happy_path() {
        ProductDTO productDTO = new ProductDTO();
        when(rabbitTemplate.convertSendAndReceive(anyString(), any(Object.class)))
                .thenReturn("test");

        productDTO = productManagementService.addProduct(productDTO);
        assertNotNull(productDTO);
    }
}
