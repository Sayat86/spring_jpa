package com.example.spring_jpa_sayat.repository;

import com.example.spring_jpa_sayat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
