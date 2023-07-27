package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    void add(Product product);

    ArrayList<Product> display();

    void delete();

    Product findById(int id);

    void editName(int id, String name);

    void editGia(int id, double gia);

    void editMoTa(int id, String moTa);

    void editNhaSanXuat(int id, String nhaSanXuat);
}
