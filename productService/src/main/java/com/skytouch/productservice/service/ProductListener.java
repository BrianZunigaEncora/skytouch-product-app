package com.skytouch.productservice.service;

import com.skytouch.dto.ProductDTO;
import com.skytouch.productservice.entity.Products;
import com.skytouch.productservice.repository.ProductsRepository;
import com.skytouch.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductListener implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductListener(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @RabbitListener(queues = Constants.GET_PRODUCT_QUEUE)
    public List<Products> getProducts() {
        return this.productsRepository.listProducts();
    }
    @RabbitListener(queues = Constants.ADD_PRODUCT_QUEUE)
    public void addProduct (ProductDTO productDTO) {
        log.info("Product received: {}", productDTO.toString());
        productsRepository.createProduct(productDTO.getName(), productDTO.getCost(), productDTO.getStoreName());
    }
}
