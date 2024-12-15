package com.example.spring_jpa_sayat.dto;

import com.example.spring_jpa_sayat.model.Category;
import com.example.spring_jpa_sayat.model.Option;
import com.example.spring_jpa_sayat.model.Product;
import com.example.spring_jpa_sayat.model.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductMapper {
    public ProductFullDto toFullDto(Product product){
        ProductFullDto productDto = new ProductFullDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryName(product.getCategory().getName());
        Map<String, String> result = new LinkedHashMap<>();


        for (Option option : product.getCategory().getOptions()) {
            Value foundValue = null;
            for (Value value : product.getValues()) {
                if (value.getOption().equals(option)) {
                    foundValue = value;
                    break;
                }
            }
            if (foundValue != null) {
                result.put(option.getName(), foundValue.getName());
            }
            else {
                result.put(option.getName(), null);
            }
        }
        productDto.setOptionsMap(result);
        return productDto;
    }

    public ProductShortDto toShortDto(Product product) {
        ProductShortDto productShortDto = new ProductShortDto();
        productShortDto.setId(product.getId());
        productShortDto.setName(product.getName());
        productShortDto.setPrice(product.getPrice());
        productShortDto.setCategoryName(product.getCategory().getName());
        return productShortDto;
    }

    public List<ProductShortDto> toShortDto(List<Product> products) {
        List<ProductShortDto> productShortDtoList = new ArrayList<>();
        for (Product product : products) {
            ProductShortDto shortDto = toShortDto(product);
            productShortDtoList.add(shortDto);
        }
        return productShortDtoList;
    }

    public Product fromCreate(ProductCreateDto productCreateDto) {
        Category category = new Category();
        category.setId(productCreateDto.getCategoryId());

        return Product.builder()
                .name(productCreateDto.getName())
                .price(productCreateDto.getPrice())
                .category(category)
                .build();
    }
}
