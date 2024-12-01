package com.example.spring_jpa_sayat.repository;

import com.example.spring_jpa_sayat.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
