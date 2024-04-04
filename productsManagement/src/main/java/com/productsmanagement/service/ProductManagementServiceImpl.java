package com.productsmanagement.service;

import com.skytouch.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    @Override
    public List<ProductDTO> getAllProducts() {
        //TODO: Implements to retrieve from queue
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Brian Test");
        productDTO.setCost(new BigDecimal("123.4"));
        productDTO.setStoreName("Store test");

        return Arrays.asList(productDTO);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        //TODO: Implements to add product queue
        return productDTO;
    }
}
