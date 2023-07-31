package com.example.demomvc.service;

import com.example.demomvc.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {

    void add(Product product);

    List<Product> display() throws SQLException;

    void delete(int index);

    Product findById(int id);

    void edit(Product product);
    int autoId();
    void remove(int id);
}
