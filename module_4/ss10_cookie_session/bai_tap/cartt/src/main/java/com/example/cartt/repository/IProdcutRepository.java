package com.example.cartt.repository;

import com.example.cartt.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProdcutRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product ", nativeQuery = true)
    List<Product> findAll();
}
