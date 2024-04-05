package com.productsmanagement.service;

import com.productsmanagement.util.Utils;
import com.skytouch.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    @Override
    public List<ProductDTO> getAllProducts() {
        //TODO: Implements to retrieve from queue
        return Utils.getMockProducts();
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        //TODO: Implements to add product queue
        return productDTO;
    }
}
