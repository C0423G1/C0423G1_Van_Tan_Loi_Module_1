package com.example.borrowbooks.service;

import com.example.borrowbooks.model.BorrowBooks;
import com.example.borrowbooks.repository.IBorrowBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorowBooksService implements IBorowBooksService {
    @Autowired
    IBorrowBooks books;
    @Override
    public void create(int id, int iduser) {
        books.save(id,iduser);
        books.createBook(id);
    }

    @Override
    public Page<BorrowBooks> findAlll(Pageable pageable, int id) {
        return books.deleteBook(pageable,id);
    }

    @Override
    public List<BorrowBooks> findBook(int id, int idBook) {
        return books.listDeleteBook(id,idBook);
    }

    @Override
    public void delete(int id, int idBook) {
        books.deleteBorrowBook(id,idBook);
    }
}
