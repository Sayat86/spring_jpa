package com.example.spring_jpa_sayat.repository;

import com.example.spring_jpa_sayat.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {
}
