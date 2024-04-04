package com.productsmanagement.controller;

import com.productsmanagement.service.ProductManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-management")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    ProductManagementController (final ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productManagementService.getAllProducts());
        return "view-products";
    }


}
