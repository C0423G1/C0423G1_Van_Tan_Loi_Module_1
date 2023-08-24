package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void create(User user);
}
