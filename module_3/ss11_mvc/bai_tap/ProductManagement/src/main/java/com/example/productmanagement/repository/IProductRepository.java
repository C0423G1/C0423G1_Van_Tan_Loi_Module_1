package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IProductRepository {
    void add(Product product);

    List<Product> display();

    void delete(int index);

    Product findById(int id);

    void edit(Product product);
    int autoId();
    void remove(int id);
}
