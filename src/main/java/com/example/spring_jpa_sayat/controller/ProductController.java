package com.example.spring_jpa_sayat.controller;

import com.example.spring_jpa_sayat.dto.ProductFullDto;
import com.example.spring_jpa_sayat.dto.ProductMapper;
import com.example.spring_jpa_sayat.dto.ProductShortDto;
import com.example.spring_jpa_sayat.model.Product;
import com.example.spring_jpa_sayat.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductShortDto> findAll() {
        List<Product> products = productRepository.findAllWithCategories();
        return productMapper.toShortDto(products);
    }

    @GetMapping("/{id}")
    public ProductFullDto findById(@PathVariable int id) {
        Product product = productRepository.findByIdValuesAndOptions(id).orElseThrow()
        return productMapper.toFullDto(product);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
