package com.productsmanagement.exception;

import com.skytouch.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DuplicatedProductException extends RuntimeException {
    private final ProductDTO productDTO;
    private final String errorMessage;

    public DuplicatedProductException (ProductDTO productDTO, String errorMessage) {
        this.productDTO = productDTO;
        this.errorMessage = errorMessage;
    }
}
