package com.skytouch.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    @NotNull
    @Pattern(regexp = "[^a-zA-Z0-9]", message = "No special characters allowed" )
    private String name;
    @NotNull
    private BigDecimal cost;
    @Pattern(regexp = "[^a-zA-Z0-9]", message = "No special characters allowed" )
    private String storeName;
}
