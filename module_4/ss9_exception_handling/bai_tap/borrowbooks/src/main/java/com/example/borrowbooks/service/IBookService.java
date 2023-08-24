package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void create(Book book);
}
