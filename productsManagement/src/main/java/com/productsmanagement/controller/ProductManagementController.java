package com.productsmanagement.controller;

import com.productsmanagement.service.ProductManagementService;
import com.skytouch.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    ProductManagementController (final ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping("")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productManagementService.getAllProducts());
        return "product-catalog";
    }

    @GetMapping("/products/add")
    public String addBookView(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "add-product";
    }

    @PostMapping("/products/add")
    public RedirectView addProductAction(@ModelAttribute("product") ProductDTO product, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/products/add", true);
        ProductDTO savedProduct = productManagementService.addProduct(product);
        redirectAttributes.addFlashAttribute("savedProduct", savedProduct);
        redirectAttributes.addFlashAttribute("addProductSuccess", true);
        return redirectView;
    }

}
