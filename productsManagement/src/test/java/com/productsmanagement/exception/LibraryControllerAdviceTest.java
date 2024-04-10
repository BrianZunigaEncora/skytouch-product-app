package com.productsmanagement.exception;

import com.productsmanagement.util.ProductErrors;
import com.productsmanagement.util.Utils;
import com.skytouch.dto.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerAdviceTest {
    private static ErrorHandlerControllerAdvice errorHandlerControllerAdvice;

    @BeforeAll
    public static void init() {
        errorHandlerControllerAdvice = new ErrorHandlerControllerAdvice();
    }

    @Test
    public void duplicateProduct () {
        ProductException duplicatedProductException = new ProductException(ProductErrors.DUPLICATED_PRODUCT);
        ModelAndView modelAndView = errorHandlerControllerAdvice.productError(duplicatedProductException);

        assertNotNull(modelAndView.getModel());
        assertFalse(modelAndView.getModel().isEmpty());
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_MESSAGE));
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_OBJECT));
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_REF));
        assertEquals(modelAndView.getViewName(), ProductErrors.ERROR_PAGE);

    }

    @Test
    public void generalError() {
        Exception exception = new Exception("Test Error Mock");
        ModelAndView modelAndView = errorHandlerControllerAdvice.generalError(exception);

        assertNotNull(modelAndView.getModel());
        assertFalse(modelAndView.getModel().isEmpty());
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_MESSAGE));
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_OBJECT));
        assertNotNull(modelAndView.getModel().get(ProductErrors.ERROR_REF));
        assertEquals(modelAndView.getViewName(), ProductErrors.ERROR_PAGE);
    }

}
