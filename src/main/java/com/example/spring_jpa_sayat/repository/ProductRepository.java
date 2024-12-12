package com.example.spring_jpa_sayat.repository;

import com.example.spring_jpa_sayat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByPriceBetween(Double price, Double price2);

    @Query("select p from Product p " +
            "join fetch p.category c " +
            "left join fetch p.values v " +
            "left join fetch v.option o " +
            "where p.id = :id")
    Optional<Product> findByIdValuesAndOptions(int id);

    @Query("select p from Product p join fetch p.category")
    List<Product> findAllWithCategories();
}
