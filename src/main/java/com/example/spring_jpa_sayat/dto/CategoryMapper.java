package com.example.spring_jpa_sayat.dto;

import com.example.spring_jpa_sayat.model.Category;
import com.example.spring_jpa_sayat.model.Option;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
    public Category fromCreate(CategoryCreateDto createDto) {
        Category category = new Category();
        category.setName(createDto.getName());

        List<Option> options = createDto.getOptions().stream()
                .map(optionName -> {
                    Option option = new Option();
                    option.setName(optionName);
                    option.setCategory(category);
                    return option;
                })
                .toList();
        category.setOptions(options);
        return category;
    }

    //Category -> CategoryWithOptionsDto
    public CategoryWithOptionsDto toWithOptionsDto(Category category) {
        CategoryWithOptionsDto categoryWithOptionsDto = new CategoryWithOptionsDto();
        categoryWithOptionsDto.setId(category.getId());
        categoryWithOptionsDto.setName(category.getName());

        List<OptionShortDto> optionShortDtoList = new ArrayList<>();
        for (Option option : category.getOptions()) {
            OptionShortDto optionShortDto = new OptionShortDto();
            optionShortDto.setId(option.getId());
            optionShortDto.setName(option.getName());
            optionShortDtoList.add(optionShortDto);
        }
        categoryWithOptionsDto.setOptions(optionShortDtoList);
        return categoryWithOptionsDto;
    }
}
