package com.example.spring_jpa_sayat.dto;

import lombok.Data;

@Data
public class ProductCreateDto {
    private String name;
    private double price;
    private int categoryId;
}
