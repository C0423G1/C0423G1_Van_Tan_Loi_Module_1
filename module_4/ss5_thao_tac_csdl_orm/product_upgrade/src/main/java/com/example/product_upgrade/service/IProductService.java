package com.example.product_upgrade.service;


import com.example.product_upgrade.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
     List<Product> findAll();

    void create(Product product);
    void delete(int id);
     Product findById(int id);

    List<Product> findByName(String name);
}
