package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Long> {
    @Query(value = "select * from sach where so_luong > 0", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
}
