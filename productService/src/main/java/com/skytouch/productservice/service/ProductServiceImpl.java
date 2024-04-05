package com.skytouch.productservice.service;

import com.skytouch.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(ProductDTO productDTO) {
        // TODO: Implements logic to retrieve from queue and insert in DB with Stored procedures
    }
}
