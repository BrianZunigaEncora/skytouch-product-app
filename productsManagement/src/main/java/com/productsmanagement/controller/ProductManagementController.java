package com.productsmanagement.controller;

import com.productsmanagement.service.ProductManagementService;
import com.skytouch.dto.ProductDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-management")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    ProductManagementController (final ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productManagementService.getAllProducts();
    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productManagementService.addProduct(productDTO);
    }

}
