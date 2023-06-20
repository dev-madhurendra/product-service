package com.zemoso.springbootassignment.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
// used to create instance of the class using a fluent APIs
// Inject builder method in the class
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String productImage;
    private String name;
    private String seller;
    private String description;
    private BigDecimal price;
}
