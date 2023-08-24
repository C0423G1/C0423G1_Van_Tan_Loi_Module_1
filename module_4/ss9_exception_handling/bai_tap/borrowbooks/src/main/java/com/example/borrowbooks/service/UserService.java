package com.example.borrowbooks.service;

import com.example.borrowbooks.model.User;
import com.example.borrowbooks.repository.IBookRepository;
import com.example.borrowbooks.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }
}
