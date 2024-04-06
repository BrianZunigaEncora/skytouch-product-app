package com.productsmanagement.exception;

import com.productsmanagement.exception.DuplicatedProductException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@ControllerAdvice
public class LibraryControllerAdvice {
    @ExceptionHandler (value = DuplicatedProductException.class)
    public ModelAndView duplicatedProduct(DuplicatedProductException error) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("object", error.getProductDTO());
        modelAndView.addObject("ref", error.getProductDTO().getName());
        modelAndView.addObject("message", error.getErrorMessage());
        modelAndView.setViewName("error-product");
        return modelAndView;
    }

    @ExceptionHandler (value = Exception.class)
    public ModelAndView duplicatedProduct(Exception error) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("object", Arrays.toString(error.getStackTrace()));
        modelAndView.addObject("ref", error.getClass());
        modelAndView.addObject("message", error.getMessage());
        modelAndView.setViewName("error-product");
        return modelAndView;
    }
}
