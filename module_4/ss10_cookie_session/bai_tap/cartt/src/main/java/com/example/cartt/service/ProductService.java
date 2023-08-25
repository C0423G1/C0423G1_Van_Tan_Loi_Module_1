package com.example.cartt.service;

import com.example.cartt.model.Product;
import com.example.cartt.repository.IProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProdcutRepository repository;
    @Override
    public List<Product> list() {
        return repository.findAll();
    }
}
