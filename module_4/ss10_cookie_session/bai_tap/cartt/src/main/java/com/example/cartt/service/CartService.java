package com.example.cartt.service;

import com.example.cartt.model.Cartt;
import com.example.cartt.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    ICartRepository repository;
    @Override
    public List<Cartt> list() {
        return repository.findAll() ;
    }

    @Override
    public List<Cartt> listId(int id) {
        return repository.listId(id);
    }

    @Override
    public void listIdCreate(int id) {
        repository.listIdCreate(id);
    }

    @Override
    public void idCreate(int id) {
        repository.idCreate(id);
    }

    @Override
    public void success() {
        repository.success();
    }
}
