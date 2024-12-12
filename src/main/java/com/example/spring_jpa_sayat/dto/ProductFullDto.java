package com.example.spring_jpa_sayat.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ProductFullDto {
    private int id;
    private String name;
    private Double price;
    private String categoryName;
    private Map<String, String> optionsMap;
}
