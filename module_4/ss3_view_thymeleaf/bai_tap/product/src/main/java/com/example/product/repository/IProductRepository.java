package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IProductRepository {
     List<Product> findAll();

     void create(Product products);
     void delete(int id);
      Product findById(int id) ;
}
