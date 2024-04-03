package com.skytouch.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {
    private String name;
    private BigDecimal cost;
    private String storeName;
}
