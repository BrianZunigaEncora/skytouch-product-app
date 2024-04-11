package com.skytouch.productservice.service;

import com.skytouch.dto.ProductDTO;
import com.skytouch.productservice.entity.Products;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);
    List<Products> getProducts();
}
