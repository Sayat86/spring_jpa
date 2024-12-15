package com.example.spring_jpa_sayat.dto;

import com.example.spring_jpa_sayat.model.Category;
import com.example.spring_jpa_sayat.model.Option;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
    public Category fromCreate(CategoryCreateDto categoryCreateDto) {
        List<Option> options = new ArrayList<>();
        for (String stringOptionName : categoryCreateDto.getOptions()) {
            Option option = new Option();
            option.setName(stringOptionName);
            options.add(option);
        }
        return Category.builder()
                .name(categoryCreateDto.getName())
                .options(options)
                .build();
    }
}
