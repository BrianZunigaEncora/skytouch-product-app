package com.productsmanagement.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.productsmanagement.service.ProductManagementService;
import com.productsmanagement.util.Utils;
import com.skytouch.dto.ProductDTO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import java.nio.charset.Charset;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductManagementController.class)
@RunWith(SpringRunner.class)
public class ProductManagementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductManagementService productManagementService;

    @Mock
    private Model model;

    ObjectWriter objectWriter;

    @BeforeAll
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    @Test
    public void getHomePage() throws Exception {
        this.mockMvc.perform(get(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }


    @Test
    public void happy_path_products() throws Exception {
        when(productManagementService.getAllProducts()).thenReturn(Utils.getMockProducts());

        this.mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("product-catalog"))
                .andExpect(model().attribute("products", Utils.getMockProducts()));
    }

    @Test
    public void getAddProduct() throws Exception{
        this.mockMvc.perform(get("/products/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("add-product"))
                .andExpect(model().attribute("product", new ProductDTO()));
    }

    @Test
    public void addProduct_happy_path() throws Exception {
        ProductDTO mockRequestProduct = Utils.mockDtoObject();
        when(productManagementService.addProduct(any(ProductDTO.class))).thenReturn(Utils.mockDtoObject());

        MockHttpServletRequestBuilder requestAddProduct = MockMvcRequestBuilders
                .post("/products/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", mockRequestProduct.getName())
                .param("cost", String.valueOf(mockRequestProduct.getCost()))
                .param("storeName",mockRequestProduct.getStoreName());

        mockMvc.perform(requestAddProduct)
                .andExpect(redirectedUrl("/products/add"))
                .andExpect(flash().attribute("savedProduct", mockRequestProduct))
                .andExpect(flash().attribute("addProductSuccess", true));
    }

}
