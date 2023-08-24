package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.BorrowBooks;
import com.example.borrowbooks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
