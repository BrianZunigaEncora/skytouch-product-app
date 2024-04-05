package com.productsmanagement.util;

import com.skytouch.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<ProductDTO> getMockProducts () {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Brian 1 Test");
        productDTO.setCost(new BigDecimal("123.4"));
        productDTO.setStoreName("Store test");

        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setName("Brian 2 test");
        productDTO2.setCost(new BigDecimal("24.4"));
        productDTO2.setStoreName("Store 2 test");

        ProductDTO productDTO3 = new ProductDTO();
        productDTO3.setName("Brian 3 Test");
        productDTO3.setCost(new BigDecimal("142.4"));
        productDTO3.setStoreName("Store 3 test");


        return Arrays.asList(productDTO, productDTO2, productDTO3);
    }
}
