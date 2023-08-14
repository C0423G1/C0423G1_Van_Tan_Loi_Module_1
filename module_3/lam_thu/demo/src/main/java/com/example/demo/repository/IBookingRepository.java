package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IBookingRepository {
    List<Book> display() throws SQLException;

    void add(String nameBook, int soLuong, String tacGia, int theLoai) throws SQLException;

    ArrayList<Category> category() throws SQLException;

    void delete(int id) throws SQLException;
}
