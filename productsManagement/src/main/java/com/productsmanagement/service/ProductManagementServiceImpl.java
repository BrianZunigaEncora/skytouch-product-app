package com.productsmanagement.service;

import com.productsmanagement.exception.ProductException;
import com.productsmanagement.util.ProductErrors;
import com.skytouch.dto.ProductDTO;
import com.skytouch.utils.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductManagementServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        Object response = rabbitTemplate.convertSendAndReceive(
                        Constants.GET_PRODUCT_QUEUE,
                        Constants.GET_PRODUCT_QUEUE);
        if (response instanceof List)
            return (List<ProductDTO>)response;
        else if (response == null)
            throw new ProductException(ProductErrors.MICROSERVICE_NOT_AVAILABLE);
        throw new ProductException(ProductErrors.UNEXPECTED_TYPE);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        rabbitTemplate.convertAndSend(Constants.ADD_PRODUCT_QUEUE, productDTO);
        return productDTO;
    }

}
