package com.example.cartt.service;

import com.example.cartt.model.Cartt;

import java.util.List;

public interface ICartService {
    List<Cartt> list();

    List<Cartt> listId(int id);

    void listIdCreate(int id);

    void idCreate(int id);

    void success();
}
