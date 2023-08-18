package com.example.product_upgrade.repository;


import com.example.product_upgrade.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
     List<Product> findAll();

     void create(Product products);
     void delete(int id);
      Product findById(int id) ;

    List<Product> findByName(String name);
}
