package com.zemoso.springbootassignment.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {
    private String productImage;
    private String name;
    private String seller;
    private String description;
    private BigDecimal price;
}