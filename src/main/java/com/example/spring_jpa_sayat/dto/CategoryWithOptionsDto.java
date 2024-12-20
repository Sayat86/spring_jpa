package com.example.spring_jpa_sayat.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryWithOptionsDto {
    private int id;
    private String name;
    private List<OptionShortDto> options;
}
