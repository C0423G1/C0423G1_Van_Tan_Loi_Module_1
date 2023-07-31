package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {

    void add(Product product);

    List<Product> display();

    void delete(int index);

    Product findById(int id);

    void edit(Product product);
    int autoId();
    void remove(int id);
}
