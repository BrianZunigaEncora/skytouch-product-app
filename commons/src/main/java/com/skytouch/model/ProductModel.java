package com.skytouch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String name;
    private BigDecimal cost;
    private String storeName;
}
