package com.productsmanagement.exception;

import com.productsmanagement.util.ProductErrors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import static com.productsmanagement.util.ProductErrors.*;

@ControllerAdvice
@Slf4j
public class ErrorHandlerControllerAdvice {

    /**
     *
     * @param error a product error exception with custom messages
     * @return a model view with the error view and the information to be showed
     */
    @ExceptionHandler (value = ProductException.class)
    public ModelAndView productError(ProductException error) {
        final ModelAndView modelAndView = new ModelAndView();
        log.error("Product Error: ", error);
        modelAndView.addObject(ERROR_OBJECT, Arrays.toString(error.getStackTrace()));
        modelAndView.addObject(ERROR_REF, error.toString());
        modelAndView.addObject(ERROR_MESSAGE, error.getErrorMessage());
        modelAndView.setViewName(ERROR_PAGE);
        return modelAndView;
    }

    /**
     *
     * @param error a product error exception with custom messages
     * @return a model view with the error view and the information to be showed
     */
    @ExceptionHandler (value = Exception.class)
    public ModelAndView generalError(Exception error) {
        final ModelAndView modelAndView = new ModelAndView();
        log.error("Product Error: ", error);
        modelAndView.addObject(ERROR_OBJECT, Arrays.toString(error.getStackTrace()));
        modelAndView.addObject(ERROR_REF, error.getClass());
        modelAndView.addObject(ERROR_MESSAGE, ProductErrors.MICROSERVICE_NOT_AVAILABLE);
        modelAndView.setViewName(ERROR_PAGE);
        return modelAndView;
    }
}
