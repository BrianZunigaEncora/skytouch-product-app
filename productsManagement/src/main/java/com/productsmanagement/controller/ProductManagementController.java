package com.productsmanagement.controller;

import com.productsmanagement.exception.ProductException;
import com.productsmanagement.service.ProductManagementService;
import com.productsmanagement.util.PageConstants;
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

    /**
     *
     * @return index page
     */
    @GetMapping("")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/error")
    public String getErrorPage() {
        return "index";
    }

    /**
     *
     * @param model model layer to add or retrieve information
     * @return product catalog page
     */
    @GetMapping(PageConstants.PRODUCT_CATALOG_URL)
    public String getProducts(Model model) {
        model.addAttribute(PageConstants.PRODUCTS_ATTRIBUTE , productManagementService.getAllProducts());
        return PageConstants.PRODUCT_CATALOG_PAGE;
    }

    /**
     *
     * @param model model layer to add or retrieve information
     * @return add book page
     */
    @GetMapping(PageConstants.ADD_PRODUCT_URL)
    public String addBookView(Model model) {
        model.addAttribute(PageConstants.PRODUCT_ATTRIBUTE, new ProductDTO());
        return PageConstants.ADD_PRODUCT_PAGE;
    }

    /**
     *
     * @param product product object to process
     * @param redirectAttributes redirect attributes
     * @return add product with redirect attributes
     */
    @PostMapping(PageConstants.ADD_PRODUCT_URL)
    public RedirectView addProductAction(@ModelAttribute(PageConstants.PRODUCT_ATTRIBUTE) ProductDTO product, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView(PageConstants.ADD_PRODUCT_URL, true);
        ProductDTO savedProduct = productManagementService.addProduct(product);
        redirectAttributes.addFlashAttribute(PageConstants.SAVED_PRODUCT, savedProduct);
        redirectAttributes.addFlashAttribute(PageConstants.SAVED_PRODUCT_SUCCESS, true);
        return redirectView;
    }

}
