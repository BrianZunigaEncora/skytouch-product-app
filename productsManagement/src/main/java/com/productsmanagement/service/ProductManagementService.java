package com.productsmanagement.service;

import com.skytouch.dto.ProductDTO;

import java.util.List;

public interface ProductManagementService {

    List<ProductDTO> getAllProducts ();

    ProductDTO addProduct(ProductDTO productDTO);

}
