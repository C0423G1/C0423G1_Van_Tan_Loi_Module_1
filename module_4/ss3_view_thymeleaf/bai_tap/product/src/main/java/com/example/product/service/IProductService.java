package com.example.product.service;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
     List<Product> findAll();

    void create(Product product);
    void delete(int id);
     Product findById(int id);

    ArrayList<Product> findByName(String name);
}
