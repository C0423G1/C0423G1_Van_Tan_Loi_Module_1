package com.example.borrowbooks.service;

import com.example.borrowbooks.model.BorrowBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBorowBooksService {
    void create(int id, int iduser);

    Page<BorrowBooks> findAlll(Pageable pageable, int id);



    List<BorrowBooks> findBook(int id, int idBook);

    void delete(int id, int idBook);
}
