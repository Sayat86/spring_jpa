package com.example.spring_jpa_sayat.controller;

import com.example.spring_jpa_sayat.dto.CategoryCreateDto;
import com.example.spring_jpa_sayat.dto.CategoryMapper;
import com.example.spring_jpa_sayat.dto.CategoryWithOptionsDto;
import com.example.spring_jpa_sayat.model.Category;
import com.example.spring_jpa_sayat.repository.CategoryRepository;
import com.example.spring_jpa_sayat.repository.OptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final OptionRepository optionRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @Transactional
    public CategoryWithOptionsDto create(@RequestBody CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.fromCreate(categoryCreateDto);
        categoryRepository.save(category);
        return categoryMapper.toWithOptionsDto(category);
    }
}
