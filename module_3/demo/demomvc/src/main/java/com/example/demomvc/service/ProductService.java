package com.example.demomvc.service;

import com.example.demomvc.model.Product;
import com.example.demomvc.repository.IProductRepository;
import com.example.demomvc.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    IProductRepository repository = new ProductRepository();

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public List<Product> display() throws SQLException {
        return repository.display();
    }


    @Override
    public void delete(int index) {
        repository.delete(index);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }


    @Override
    public void edit(Product product) {
        repository.edit(product);
    }

    @Override
    public int autoId() {
        return repository.autoId();
    }


    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
