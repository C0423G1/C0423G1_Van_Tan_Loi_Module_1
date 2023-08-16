package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository ;
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }
    public void delete(int id){
        repository.delete(id);
    }
    public Product findById(int id) {
        return repository.findById(id);
    }

}
