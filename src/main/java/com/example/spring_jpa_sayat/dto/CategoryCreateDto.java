package com.example.spring_jpa_sayat.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryCreateDto {
    private String name;
    private List<String> options;
}
