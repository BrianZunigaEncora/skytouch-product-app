package com.productsmanagement.exception;

import com.skytouch.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductException extends RuntimeException {
    private final String errorMessage;

    public ProductException (String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
