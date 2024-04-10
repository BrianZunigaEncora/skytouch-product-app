package com.productsmanagement.service;

import com.skytouch.dto.ProductDTO;

import java.util.List;

public interface ProductManagementService {

    /**
     *
     * @return the catalog of the products inserted
     */
    List<ProductDTO> getAllProducts ();

    /**
     *
     * @param productDTO product to be created
     * @return the new product inserted
     */
    ProductDTO addProduct(ProductDTO productDTO);

}
