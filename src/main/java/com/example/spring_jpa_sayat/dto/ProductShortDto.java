package com.example.spring_jpa_sayat.dto;

import lombok.Data;

@Data
public class ProductShortDto {
    private int id;
    private String name;
    private Double price;
    private String categoryName;
}
