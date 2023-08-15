package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import com.example.productmanagement.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository repository = new ProductRepository();

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public List<Product> display() {
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